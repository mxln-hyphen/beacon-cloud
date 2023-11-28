package com.mxln.beaconcommon.exception;

import com.mxln.beaconcommon.common.ExceptionEnums;
import lombok.Getter;

/**
 * 策略模块的校验对象
 */
@Getter
public class StrategyException extends RuntimeException {

    private Integer code;

    public StrategyException(String message, Integer code) {
        super(message);
        this.code = code;
    }


    public StrategyException(ExceptionEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }

}