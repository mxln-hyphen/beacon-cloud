package com.mxln.beaconcommon.common;

/**
 * 缓存模块的各种前缀
 */
public interface CacheConstant {

    /**
     * 客户信息
     */
    String CLIENT_BUSINESS = "client_business:";

    /**
     * 客户签名
     */
    String CLIENT_SIGN = "client_sign:";

    /**
     * 客户签名的模板
     */
    String CLIENT_TEMPLATE = "client_template:";

    /**
     * 客户的余额
     */
    String CLIENT_BALANCE = "client_balance:";

    /**
     * 号段
     */
    String PHASE = "phase:";

    /**
     * 敏感词
     */
    String DIRTY_WORD = "dirty_word";

    /**
     * 黑名单前缀
     */
    String BLACK = "black:";

    /**
     * 间隔符
     */
    String SEPARATE = ":";

    /**
     * 携号转网前缀
     */
    String TRANSFER = "transfer:";

    /**
     * 分钟的限流
     */
    String LIMIT_MINUTES = "limit:minutes";

    /**
     * 小时的限流
     */
    String LIMIT_HOURS = "limit:hours";
}
