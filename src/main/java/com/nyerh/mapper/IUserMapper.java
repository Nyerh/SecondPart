package com.nyerh.mapper;

import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    Integer getCurRec(@Param("uId") Integer uid);
    Integer getDetection(@Param("uId") Integer uid);
}
