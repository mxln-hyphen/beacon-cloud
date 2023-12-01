package com.mxln.beaconcommon.utils;

import com.mxln.beaconcommon.common.CMPP2ResultEnums;
import com.mxln.beaconcommon.common.MobileOpeartorEnum;

import java.util.HashMap;
import java.util.Map;

public class CMPP2ResultUtil {

    private static Map<Integer,String>operators = new HashMap<>();

    static {
        CMPP2ResultEnums[] cmpp2ResultEnums = CMPP2ResultEnums.values();
        for (CMPP2ResultEnums cmpp2ResultEnum : cmpp2ResultEnums) {
            operators.put(cmpp2ResultEnum.getResult(),cmpp2ResultEnum.getMsg());
        }
    }


    /**
     * 通过result拿到错误信息
     * @param result
     * @return
     */
    public static String getResultMessage(Integer result) {
        return operators.get(result);
    }
}
