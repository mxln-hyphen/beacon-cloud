package com.mxln.beaconstrategy.filter.impl;

import com.mxln.beaconcommon.pojo.StandardSubmit;
import com.mxln.beaconstrategy.filter.StrategyFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 策略模块-敏感词校验
 */
@Service(value = "dirtyword")
@Slf4j
public class DirtyWordFilter implements StrategyFilter {
    @Override
    public void strategy(StandardSubmit submit) {
        log.info("【策略模块-敏感词校验】   校验ing…………");
    }
}