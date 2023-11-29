package com.mxln.beaconcommon.common;

/**common中声明
 * RabbitMQ中的一些队列信息
 * @author zjw
 * @description
 */
public interface RabbitMQConstants {

    /**
     * 接口模块发送消息到策略模块的队列名称
     */
    String SMS_PRE_SEND = "sms_pre_send_topic";

    /**
     * 策略模块发送手机号归属地&运营商到后台管理模块的队列名称
     */
    String MOBILE_AREA_OPERATOR = "mobile_area_operator_topic";

    /**
     * 写日志到Elasticsearch的队列
     */
    String SMS_WRITE_LOG = "sms_write_log_topic";

    /**
     *状态报告的队列
     */
    String SMS_PUSH_REPORT = "sms_push_report_topic";

    /**
     * 策略模块推送消息到短信网关模块的队列前缀名称
     */
    String SMS_GATEWAY = "sms_gateway_topic_";
}
