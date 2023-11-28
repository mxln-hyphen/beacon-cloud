package com.mxln.beaconstrategy.utils;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.mxln.beaconcommon.common.CacheConstant;
import com.mxln.beaconcommon.common.ExceptionEnums;
import com.mxln.beaconcommon.common.RabbitMQConstants;
import com.mxln.beaconcommon.constant.SmsConstant;
import com.mxln.beaconcommon.pojo.StandardReport;
import com.mxln.beaconcommon.pojo.StandardSubmit;
import com.mxln.beaconstrategy.remote.BeaconCacheClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ErrorSendMsgUtil {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BeaconCacheClient cacheClient;

    /**
     * 策略模块校验未通过，发送写日志操作
     * @param submit
     */
    public void sendWriteLog(StandardSubmit submit) {
        submit.setReportState(SmsConstant.REPORT_FAIL);
        // 发送消息到写日志队列
        rabbitTemplate.convertAndSend(RabbitMQConstants.SMS_WRITE_LOG,submit);
    }

    /**
     * 策略模块校验未通过，发送状态报告操作
     */
    public void sendPushReport(StandardSubmit submit) {
        // 查询当前客户的isCallback
        Integer isCallback = cacheClient.hgetInteger(CacheConstant.CLIENT_BUSINESS + submit.getApikey(), "isCallback");
        // 查看是否需要给客户一个回调
        if(isCallback == 1){
            // 如果需要回调，再查询客户的回调地址
            String callbackUrl = cacheClient.hget(CacheConstant.CLIENT_BUSINESS + submit.getApikey(), "callbackUrl");
            // 如果回调地址不为空。
            if(!StringUtils.isEmpty(callbackUrl)){
                // 封装客户的报告推送的信息，开始封装StandardReport
                StandardReport report = new StandardReport();
                BeanUtils.copyProperties(submit,report);
                report.setIsCallback(isCallback);
                report.setCallbackUrl(callbackUrl);
                // 发送消息到RabbitMQ
                rabbitTemplate.convertAndSend(RabbitMQConstants.SMS_PUSH_REPORT,report);
            }

        }
    }
}