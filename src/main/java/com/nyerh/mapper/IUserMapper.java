package com.nyerh.mapper;

import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    //获取当前用户的当前接单量
    Integer getCurRec(@Param("uId") Integer uid);
    //获取当前用户的实名制状态值
    Integer getDetection(@Param("uId") Integer uid);
    //接单时为当前用户的接单量+1
    Integer addCurRec(@Param("uId") Integer uid);
}
