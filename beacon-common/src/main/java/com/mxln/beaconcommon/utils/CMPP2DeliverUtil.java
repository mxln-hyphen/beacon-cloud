package com.mxln.beaconcommon.utils;

import com.mxln.beaconcommon.common.CMPP2DeliverEnums;
import com.mxln.beaconcommon.common.CMPP2ResultEnums;

import java.util.HashMap;
import java.util.Map;

public class CMPP2DeliverUtil {

    private static Map<String,String>operators = new HashMap<>();

    static {
        CMPP2DeliverEnums[] cmpp2DeliverEnums = CMPP2DeliverEnums.values();
        for (CMPP2DeliverEnums cmpp2DeliverEnum : cmpp2DeliverEnums) {
            operators.put(cmpp2DeliverEnum.getStat(),cmpp2DeliverEnum.getDescription());
        }
    }


    /**
     * 通过result拿到错误信息
     * @param stat
     * @return
     */
    public static String getResultMessage(String stat) {
        return operators.get(stat);
    }
}
