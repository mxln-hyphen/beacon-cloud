package com.mxln.beaconstrategy.config;

import com.mxln.beaconcommon.common.RabbitMQConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 构建队列&交换机信息
 * @author zjw
 * @description
 */
@Configuration
public class RabbitMQConfig {

    /**
     * 策略模块发送手机号归属地&运营商到后台管理模块的队列
     * @return
     */
    @Bean
    public Queue preSendQueue(){
        return QueueBuilder.durable(RabbitMQConstants.MOBILE_AREA_OPERATOR).build();
    }

}