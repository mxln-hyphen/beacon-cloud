package com.mxln.beacontest.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxln.beacontest.entity.Channel;
import com.mxln.beacontest.entity.ClientChannel;
import com.mxln.beacontest.remote.CacheClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientChannelMapperTest {

    @Autowired
    private ClientChannelMapper mapper;

    @Autowired
    private CacheClient cacheClient;

    @Test
    public void findByClientId() throws JsonProcessingException {
        List<ClientChannel> all = mapper.findAll();

        for (ClientChannel channel : all) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(objectMapper.writeValueAsString(channel), Map.class);
            cacheClient.sadd("clientchannel:"+channel.getClientId(),map);
        }
    }
}