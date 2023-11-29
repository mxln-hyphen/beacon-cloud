package com.mxln.beacontest.entity;

import lombok.Data;

@Data
public class ClientChannel {

    private Long clientId;
    private Long channelId;
    private Integer clientChannelWeight;
    private String clientChannelNumber;
    private Integer isAvailable;

}
