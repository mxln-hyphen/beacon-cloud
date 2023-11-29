package com.mxln.beaconcommon.exception;

import com.mxln.beaconcommon.common.ExceptionEnums;
import lombok.Getter;

/**
 * 搜索模块异常信息
 */
@Getter
public class SearchException extends RuntimeException {

    private Integer code;

    public SearchException(String message, Integer code) {
        super(message);
        this.code = code;
    }


    public SearchException(ExceptionEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }

}