package com.mxln.beaconstrategy.filter.impl;

import com.mxln.beaconcommon.common.CacheConstant;
import com.mxln.beaconcommon.common.ExceptionEnums;
import com.mxln.beaconcommon.common.RabbitMQConstants;
import com.mxln.beaconcommon.constant.SmsConstant;
import com.mxln.beaconcommon.exception.StrategyException;
import com.mxln.beaconcommon.pojo.StandardSubmit;
import com.mxln.beaconstrategy.filter.StrategyFilter;
import com.mxln.beaconstrategy.remote.BeaconCacheClient;
import com.mxln.beaconstrategy.utils.DFAUtil;
import com.mxln.beaconstrategy.utils.ErrorSendMsgUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 策略模块-敏感词校验
 */
@Service(value = "dirtyword")
@Slf4j
public class DirtyWordFilter implements StrategyFilter {

    @Autowired
    private BeaconCacheClient cacheClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ErrorSendMsgUtil errorSendMsgUtil;

    @Override
    public void strategy(StandardSubmit submit) {
        log.info("【策略模块-敏感词校验】   校验ing…………");
        //1、 获取短信内容
        String text = submit.getText();

        //2、 调用DFA查看敏感词
        Set<String> dirtyWords = DFAUtil.getDirtyWord(text);

        //4、 根据返回的set集合，判断是否包含敏感词
        if(dirtyWords != null && dirtyWords.size() > 0){
            //5、 如果有敏感词，抛出异常 / 其他操作。。
            log.info("【策略模块-敏感词校验】   短信内容包含敏感词信息， dirtyWords = {}",dirtyWords);
            //发送写日志
            submit.setErrorMsg(ExceptionEnums.HAVE_DIRTY_WORD.getMsg() + "dirtyWords = " + dirtyWords);
            errorSendMsgUtil.sendWriteLog(submit);
            //发送状态报告
            errorSendMsgUtil.sendPushReport(submit);
            //抛出异常
            throw new StrategyException(ExceptionEnums.HAVE_DIRTY_WORD.getMsg()
                    ,ExceptionEnums.HAVE_DIRTY_WORD.getCode());
        }
        log.info("【策略模块-敏感词校验】   没有敏感词");

    }
}