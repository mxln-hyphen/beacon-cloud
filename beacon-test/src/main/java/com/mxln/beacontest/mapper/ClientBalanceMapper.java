package com.mxln.beacontest.mapper;

import com.mxln.beacontest.entity.ClientBalance;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ClientBalanceMapper {

    @Select("select * from client_balance where client_id = #{clientId}")
    ClientBalance findByClientId(@Param("clientId")Long clientId);

}