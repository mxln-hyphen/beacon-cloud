package com.mxln.beaconstrategy.utils;

import com.mxln.beaconcommon.pojo.StandardSubmit;

import java.util.Map;

/**
 * 通道转换工具类
 */
public class ChannelTransferUtil {

    /**
     * 不转换
     * @param submit
     * @param channel
     * @return
     */
    public static Map transfer(StandardSubmit submit, Map channel) {
        return channel;
    }
}
