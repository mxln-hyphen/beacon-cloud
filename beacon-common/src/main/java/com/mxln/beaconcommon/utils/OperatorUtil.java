package com.mxln.beaconcommon.utils;

import com.mxln.beaconcommon.common.MobileOpeartorEnum;

import java.util.HashMap;
import java.util.Map;

public class OperatorUtil {

    private static Map<String,Integer>operators = new HashMap<>();

    static {
        MobileOpeartorEnum[] opeartorEnums = MobileOpeartorEnum.values();
        for (MobileOpeartorEnum opeartorEnum : opeartorEnums) {
            operators.put(opeartorEnum.getOperatorName(),opeartorEnum.getOperatorId());
        }
    }



    public static Integer getOperatorIdByOperatorName(String operatorName) {
        return operators.get(operatorName);
    }
}
