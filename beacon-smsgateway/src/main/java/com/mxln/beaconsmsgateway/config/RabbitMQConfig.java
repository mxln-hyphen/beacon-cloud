package com.mxln.beaconsmsgateway.config;

import static com.mxln.beaconcommon.common.RabbitMQConstants.*;

import com.mxln.beaconcommon.common.RabbitMQConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final int TTL = 10000;
    private final String FANOUT_ROUTING_KEY = "";

    @Bean
    public Exchange normalExchange() {
        return ExchangeBuilder.fanoutExchange(SMS_GATEWAY_NORMAL_EXCHANGE).build();
    }

    @Bean
    public Queue normalQueue() {
        Queue queue = QueueBuilder.durable(SMS_GATEWAY_NORMAL_QUEUE)
                .withArgument("x-message-ttl", TTL)
                .withArgument("x-dead-letter-exchange", SMS_GATEWAY_DEAD_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", FANOUT_ROUTING_KEY)
                .build();
        return queue;
    }

    @Bean
    public Binding normalBinding(Exchange normalExchange, Queue normalQueue) {
        return BindingBuilder.bind(normalQueue).to(normalExchange).with("").noargs();
    }

    @Bean
    public Exchange deadExchange() {
        return ExchangeBuilder.fanoutExchange(SMS_GATEWAY_DEAD_EXCHANGE).build();
    }

    @Bean
    public Queue deadQueue() {
        return QueueBuilder.durable(SMS_GATEWAY_DEAD_QUEUE).build();
    }

    @Bean
    public Binding deadBinding(Exchange deadExchange, Queue deadQueue){
        return BindingBuilder.bind(deadQueue).to(deadExchange).with("").noargs();
    }

}
