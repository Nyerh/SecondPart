package com.nyerh.service;

import com.nyerh.entity.Demand;

import java.util.List;

public interface DemandService {
    //获取订单列表的service层
    List<Demand> getList();
    //获取订单详情
    Demand getDetail(Integer gId);
    //接单
    Integer getDemand(Integer gid,Integer uid);
}
