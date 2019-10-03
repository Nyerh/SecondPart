package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Demand {
   public Integer gId;//订单号
   public Integer orderUId;//下单人id
   public Integer recUId;//接单人id
   public Double weight;//重量
   public Integer num;//数量
   public Double price;//报价
   public String origin;//存放点
   public String target;//目的地
   public String state;//订单状态
   public String curTime;//下单时间
   public String trackNum;//快递单号
   public Integer between;//距离
   public String etc;//备注
}
