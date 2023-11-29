package com.mxln.beacontest.mapper;

import com.mxln.beacontest.entity.Channel;
import com.mxln.beacontest.entity.ClientChannel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClientChannelMapper {

    @Select("select * from client_channel where is_delete = 0")
    List<ClientChannel> findAll();


}
