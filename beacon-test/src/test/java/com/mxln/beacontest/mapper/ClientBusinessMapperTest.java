package com.mxln.beacontest.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxln.beacontest.entity.ClientBusiness;
import com.mxln.beacontest.remote.CacheClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ClientBusinessMapperTest {

    @Autowired
    private ClientBusinessMapper mapper;

    @Autowired
    CacheClient cacheClient;

    @Test
    void findById() throws JsonProcessingException {
        ClientBusiness cb = mapper.findById(1L);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(objectMapper.writeValueAsString(cb), Map.class);
        cacheClient.hmset("client_business:" + cb.getApikey(),map);
    }
}