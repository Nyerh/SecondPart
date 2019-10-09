package com.nyerh.service;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowUserService {
    //个人信息展示
    User showUser(Integer uId);
    //历史需求展示
    List<Demand> pastDemand(Integer uId);
    //接单记录展示
    List<Demand> orderRecord(Integer uId);
}
