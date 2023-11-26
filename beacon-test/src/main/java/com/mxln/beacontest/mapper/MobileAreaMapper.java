package com.mxln.beacontest.mapper;

import com.mxln.beacontest.entity.MobileArea;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MobileAreaMapper {

    @Select("select mobile_number,mobile_area,mobile_type from mobile_area")
    List<MobileArea> findAll();
}
