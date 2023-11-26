package com.mxln.beaconapi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import com.mxln.beaconcommon.pojo.StandardSubmit;

import java.util.Map;

/**
 * @author zjw
 * @description  策略模式的上下文对象
 */
@Component
@RefreshScope
@Slf4j
public class CheckFilterContext {

    // Spring的IOC会将对象全部都放到Map集合中
    // 基于4.x中Spring提供的反省注解，基于Map只拿到需要的类型对象即可
    @Autowired
    private Map<String, CheckFilter> checkFiltersMap;

    // 基于Nacos获取到执行的顺序和需要执行的校验对象
    @Value("${filters:apikey,ip,sign,template,mobile,fee}")
    private String filters;

    /**
     * 当前check方法用于管理校验链的顺序
     */
    public void check(StandardSubmit submit){
        //1. 将获取到filters基于,做切分
        String[] filterArray = filters.split(",");
        log.info(filters);
        //2. 遍历数组即可
        for (String filter : filterArray) {
            log.info(filter);
            CheckFilter checkFilter = checkFiltersMap.get(filter);
            checkFilter.check(submit);
        }
    }
}