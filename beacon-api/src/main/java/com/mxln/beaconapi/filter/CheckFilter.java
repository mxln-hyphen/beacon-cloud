package com.mxln.beaconapi.filter;

import com.mxln.beaconcommon.pojo.StandardSubmit;

/**
 *
 * @author zjw
 * @description 做策略模式的父接口
 */
public interface CheckFilter {

    /**
     * 校验！！！！
     * @param submit
     */
    void check(StandardSubmit submit);

}