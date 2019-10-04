package com.nyerh.mapper;

import com.nyerh.entity.Demand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDemandMapper {
    //获取Demand的展示集合，内容为订单号/重量/数量/报价/存放点/目的地/下单时间/订单状态
    List<Demand> getList();
    //获取Demand的详情集合，内容为订单号/重量/数量/报价/存放点/目的地/下单人/下单时间/里程数
    Demand getDetail(@Param("gId") Integer gid);
    //接单（改变订单的rec_u_id为当前用户，当前订单状态state改为sending派送中）
    Integer getDemand(@Param("gId") Integer gid,@Param("uId") Integer uid);
}
