package com.mxln.beaconstrategy.filter;

import com.mxln.beaconcommon.pojo.StandardSubmit;

public interface StrategyFilter {

    /**
     * 校验！！！！
     * @param submit
     */
    void strategy(StandardSubmit submit);
}