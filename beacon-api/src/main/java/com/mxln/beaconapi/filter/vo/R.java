package com.mxln.beaconapi.filter.vo;

import com.mxln.beaconcommon.exception.ApiException;

public class R {

    /**
     * 成功信息
     *
     * @return
     */
    public static ResultVO ok() {
        ResultVO r = new ResultVO();
        r.setCode(0);
        r.setMsg("接收成功");
        return r;
    }

    /**
     * 失败信息
     *
     * @return
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO r = new ResultVO();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    /**
     * 失败信息
     * @param ex 异常
     * @return
     */
    public static ResultVO error(ApiException ex) {
        ResultVO r = new ResultVO();
        r.setCode(ex.getCode());
        r.setMsg(ex.getMessage());
        return r;
    }


}