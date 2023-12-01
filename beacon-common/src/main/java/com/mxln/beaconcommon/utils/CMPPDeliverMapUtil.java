package com.mxln.beaconcommon.utils;

import com.mxln.beaconcommon.pojo.StandardReport;
import com.mxln.beaconcommon.pojo.StandardSubmit;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于CMPP状态回调时，获取核心信息的方式
 */
public class CMPPDeliverMapUtil {

    private static ConcurrentHashMap<String, StandardReport> map = new ConcurrentHashMap<>();

    public static void put(String sequence , StandardReport submit){
        map.put(sequence+"",submit);
    }

    public static StandardReport get(String sequence){
        return map.get(sequence+"");
    }

    public static StandardReport remove(String sequence){
        return map.remove(sequence+"");
    }

}
