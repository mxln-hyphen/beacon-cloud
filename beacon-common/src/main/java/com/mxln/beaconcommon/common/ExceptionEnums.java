package com.mxln.beaconcommon.common;

import lombok.Getter;

@Getter
public enum ExceptionEnums {

    ERROR_APIKEY(-1,"非法的apikey"),
    IP_NOT_WHITE(-2,"请求的ip不在白名单内"),
    ERROR_SIGN(-3,"无可用签名"),
    ERROR_TEMPLATE(-4,"无可用模板"),
    ERROR_MOBILE(-5,"手机号格式不正确"),
    BALANCE_NOT_ENOUGH(-6,"客户余额不足"),
    SNOWFLAKE_OUT_OF_RANGE(-11,"雪花算法的机器id或服务id超出最大范围"),
    SNOWFLAKE_TIME_BACK(-12,"雪花算法出现时间回拨"),
    HAVE_DIRTY_WORD(-13,"短信包含敏感词"),
    BLACK_GLOBAL(-14,"当前手机号为平台黑名单"),
    BLACK_CLIENT(-15,"当前手机号为客户黑名单"),
    ONE_MINUTE_LIMIT(-16,"60秒内不能发送一条以上短信"),
    ONE_HOUR_LIMIT(-17,"1小时内不能发送三条以上短信"),
    NO_CHANNEL(-18,"没有可用的通道"),
    UNKNOWN_ERROR(-9999,"未知的错误"),
    SEARCH_INDEX_ERROR(-19,"添加失败")
    ;

    private Integer code;

    private String msg;

    ExceptionEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}