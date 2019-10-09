package com.nyerh.mapper;


import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IUserShow {
    //个人信息展示
    User showUser(@Param("uId") Integer uId);
    //历史需求展示
    List<Demand> pastDemand(@Param("uId")Integer uId);
    //接单记录展示
    List<Demand> orderRecord(@Param("uId")Integer uId);

}
