package com.mxln.beacontest.mapper;

import com.mxln.beacontest.entity.Channel;
import com.mxln.beacontest.entity.MobileArea;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChannelMapper {

    @Select("select * from channel where is_delete = 0")
    List<Channel> findAll();


}
