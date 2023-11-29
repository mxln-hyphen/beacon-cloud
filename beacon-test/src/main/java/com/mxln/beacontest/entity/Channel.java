package com.mxln.beacontest.entity;

import lombok.Data;

/**
 *
 */
@Data
public class Channel {
    private Long id;
    private String channelName;
    private Integer channelType;
    private String channelArea;
    private String channelAreaCode;
    private Long channelPrice;
    private Integer channelProtocal;
    private String channelIp;
    private Integer channelPort;
    private String channelUsername;
    private String channelPassword;
    private String channelNumber;
    private Integer isAvailable;
}