package com.mxln.beaconapi.filter.impl;

import com.mxln.beaconapi.filter.CheckFilter;
import com.mxln.beaconapi.filter.remote.BeaconCacheClient;
import com.mxln.beaconcommon.common.ApiException;
import com.mxln.beaconcommon.common.CacheConstant;
import com.mxln.beaconcommon.common.ExceptionEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mxln.beaconcommon.pojo.StandardSubmit;

import java.util.Map;

/**
 * @author zjw
 * @description  校验客户的apikey是否合法
 */
@Service(value = "apikey")
@Slf4j
public class ApiKeyCheckFilter implements CheckFilter {

    @Autowired
    private BeaconCacheClient cacheClient;


    @Override
    public void check(StandardSubmit submit) {
        log.info("【接口模块-校验apikey】   校验ing…………");
        //1. 基于cacheClient查询客户信息
        Map clientBusiness = cacheClient.hGetAll(CacheConstant.CLIENT_BUSINESS + submit.getApikey());

        //2. 如果为null，直接扔异常
        if(clientBusiness == null || clientBusiness.size() == 0){
            log.info("【接口模块-校验apikey】 非法的apikey = {}",submit.getApikey());
            throw new ApiException(ExceptionEnums.ERROR_APIKEY);
        }

        //3. 正常封装数据
        submit.setClientId(Long.parseLong(clientBusiness.get("id") + ""));
        log.info("【接口模块-校验apikey】 查询到客户信息 clientBusiness = {}",clientBusiness);
    }
}