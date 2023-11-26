package com.mxln.beaconstrategy.mq;

import com.mxln.beaconstrategy.filter.StrategyFilterContext;
import com.rabbitmq.client.Channel;
import com.mxln.beaconcommon.common.RabbitMQConstants;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mxln.beaconcommon.pojo.StandardSubmit;

import java.io.IOException;


@Component
@Slf4j
public class PreSendListener {

    /**
     * 整个策略模块的校验
     */
    @Autowired
    private StrategyFilterContext filterContext;

    @RabbitListener(queues = RabbitMQConstants.SMS_PRE_SEND)
    public void listen(StandardSubmit submit, Message message, Channel channel) throws IOException {
        log.info("【策略模块-接收消息】 接收到接口模块发送的消息 submit = {}",submit);
        // 处理业务…………

        try {
            //校验
            filterContext.strategy(submit);
            log.info("【策略模块-消费完毕】手动ack");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("【策略模块-消费失败】凉凉~~~");
        }


    }
}