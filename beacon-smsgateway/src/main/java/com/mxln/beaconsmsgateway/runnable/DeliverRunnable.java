package com.mxln.beaconsmsgateway.runnable;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.mxln.beaconcommon.common.CacheConstant;
import com.mxln.beaconcommon.common.RabbitMQConstants;
import com.mxln.beaconcommon.constant.SmsConstant;
import com.mxln.beaconcommon.pojo.StandardReport;
import com.mxln.beaconcommon.utils.CMPP2DeliverUtil;
import com.mxln.beaconcommon.utils.CMPPDeliverMapUtil;
import com.mxln.beaconsmsgateway.remote.BeaconCacheClient;
import com.mxln.beaconsmsgateway.utils.SpringUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class DeliverRunnable implements Runnable {

    private RabbitTemplate rabbitTemplate = SpringUtil.getBeanByClass(RabbitTemplate.class);

    private BeaconCacheClient cacheClient = SpringUtil.getBeanByClass(BeaconCacheClient.class);

    private final String DELIVRD = "DELIVRD";

    private long msgId;

    private String stat;

    public DeliverRunnable(long msgId, String stat) {
        this.msgId = msgId;
        this.stat = stat;
    }

    @Override
    public void run() {
        //1、基于msgId拿到临时存储的Report对象
        StandardReport report = CMPPDeliverMapUtil.remove(msgId + "");

        //2、确认当前短信发送的最终状态
        if(!StringUtils.isEmpty(stat) && stat.equals(DELIVRD)){
            // 短信发送成功
            report.setReportState(SmsConstant.REPORT_SUCCESS);
        }else{
            // 短信发送失败
            report.setReportState(SmsConstant.REPORT_FAIL);
            report.setErrorMsg(CMPP2DeliverUtil.getResultMessage(stat));
        }

        //3、客户状态报告推送，让网关模块查询缓存，当前客户是否需要状态报告推送
        // 查询当前客户的isCallback
        Integer isCallback = cacheClient.hgetInteger(CacheConstant.CLIENT_BUSINESS + report.getApikey(), "isCallback");
        if(isCallback == 1){
            // 如果需要回调，再查询客户的回调地址
            String callbackUrl = cacheClient.hget(CacheConstant.CLIENT_BUSINESS + report.getApikey(), "callbackUrl");
            // 如果回调地址不为空。
            if(!StringUtils.isEmpty(callbackUrl)){
                // 封装客户的报告推送的信息，开始封装StandardReport
                report.setIsCallback(isCallback);
                report.setCallbackUrl(callbackUrl);
                // 发送消息到RabbitMQ
                rabbitTemplate.convertAndSend(RabbitMQConstants.SMS_PUSH_REPORT,report);
            }
        }
        //4、发送消息，让搜索模块对之前写入的信息做修改，这里需要做一个死信队列，延迟10s发送修改es信息的消息
        // 声明好具体的交换机和队列后，直接发送report到死信队列即可
        rabbitTemplate.convertAndSend(RabbitMQConstants.SMS_GATEWAY_NORMAL_EXCHANGE,"",report);

    }
}