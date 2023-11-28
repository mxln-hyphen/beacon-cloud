package com.mxln.beacontest.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DirtywordMapper {

    @Select("select dirtyword from mobile_dirtyword")
    List<String> findDirtyWord();


}
