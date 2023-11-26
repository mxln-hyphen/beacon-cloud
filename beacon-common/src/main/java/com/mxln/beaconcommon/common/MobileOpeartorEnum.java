package com.mxln.beaconcommon.common;

import lombok.Getter;

@Getter
public enum MobileOpeartorEnum {

    CHINA_MOBILE(1,"移动"),
    CHINA_UNICOM(2,"联通"),
    CHINA_TELECOM(3,"电信"),
    ;

    private Integer operatorId;

    private String operatorName;

    MobileOpeartorEnum(Integer operatorId, String operatorName) {
        this.operatorId = operatorId;
        this.operatorName = operatorName;
    }
}
