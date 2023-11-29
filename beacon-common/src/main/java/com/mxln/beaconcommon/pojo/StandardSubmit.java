package com.mxln.beaconcommon.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 在接口模块-策略模块-短信网关模块需要做校验和封装的POJO类对象
 *
 * @author zjw
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardSubmit implements Serializable {

    /**
     * 针对当前短信的唯一标识
     */
    private Long sequenceId;

    /**
     * 客户端ID
     */
    private Long clientId;

    /**
     * 客户端的ip白名单
     */
    private String ip;

    /**
     * 客户业务内的uid
     */
    private String uid;

    /**
     * 目标手机号
     */
    private String mobile;

    /**
     * 短信内容的签名
     */
    private String sign;

    /**
     * 短信内容
     */
    private String text;

    /**
     * 短信的发送时间，当前系统时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime sendTime;

    /**
     * 当前短信的费用
     */
    private Long fee;

    /**
     * 目标手机号的运营商
     */
    private Integer operatorId;


    /**
     * 目标手机号的归属地区号  0451  0455
     */
    private Integer areaCode;

    /**
     * 目标手机号的归属地  哈尔滨，  绥化~
     */
    private String area;

    /**
     * 通道下发的源号码  106934985673485645
     */
    private String srcNumber;

    /**
     * 通道的id信息
     */
    private Long channelId;

    /**
     * 短信的发送状态， 0-等待ing，1-成功，2-失败
     */
    private int reportState;

    /**
     * 由服务方提供，可以在后台首页中查看
     */
    private String apikey;

    /**
     * 0-验证码短信 1-通知类短信 2-营销类短信
     */
    private Integer state;

    /**
     * 客户端的真实ip
     * @return
     */
    private String realIp;

    /**
     * 签名的id
     */
    private Long signId;

    /**
     * 短信发送失败的原因是什么，记录在当前属性
     */
    private String errorMsg;

    /**
     * 是否已经携号转网
     */
    private Boolean IsTransfer;

    /**
     * 针对1小时限流规则储存的系统时间毫秒值
     */
    private Long oneHourLimitMilli;

    // 后续再做封装~~~~

}