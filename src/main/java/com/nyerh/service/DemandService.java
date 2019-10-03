package com.nyerh.service;

import com.nyerh.entity.Demand;

import java.util.List;

public interface DemandService {
    //获取订单列表的service层
    List<Demand> getList();
}
