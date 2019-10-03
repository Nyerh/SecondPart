package com.nyerh.mapper;

import com.nyerh.entity.Demand;

import java.util.List;

public interface IDemandMapper {
    //获取Demand的展示集合，内容为订单号/重量/数量/报价/存放点/目的地/下单时间/订单状态
    List<Demand> getList();
}
