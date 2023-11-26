package com.mxln.beacontest.mapper;

import com.mxln.beacontest.entity.ClientTemplate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClientTemplateMapper {

    @Select("select * from client_template where sign_id = #{signId}")
    List<ClientTemplate> findBySignId(@Param("signId") Long signId);

}