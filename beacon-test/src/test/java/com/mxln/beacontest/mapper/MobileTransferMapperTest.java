package com.mxln.beacontest.mapper;

import com.mxln.beacontest.entity.MobileTransfer;
import com.mxln.beacontest.remote.CacheClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MobileTransferMapperTest {

    @Autowired
    private MobileTransferMapper mapper;

    @Autowired
    private CacheClient cacheClient;


    @Test
    public void findAll() {
        List<MobileTransfer> list = mapper.findAll();

        for (MobileTransfer mobileTransfer : list) {
            cacheClient.set("transfer:" + mobileTransfer.getTransferNumber(), String.valueOf(mobileTransfer.getNowIsp()));
        }
    }
}