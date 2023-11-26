package com.mxln.beacontest.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxln.beacontest.entity.ClientBalance;
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
public class ClientBalanceMapperTest {

    @Autowired
    private ClientBalanceMapper mapper;

    @Autowired
    private CacheClient cacheClient;

    @Test
    public void findByClientId() throws JsonProcessingException {
        ClientBalance byClientId = mapper.findByClientId(1L);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(objectMapper.writeValueAsString(byClientId), Map.class);

        cacheClient.hmset("client_balance:1", map);
    }
}