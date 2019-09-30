package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Demand {
   public Integer gId;
   public Integer orderUId;
   public Integer recUId;
   public Double weight;
   public Integer num;
   public Double price;
   public String origin;
   public String target;
   public String state;
   public String curTime;
   public String trackNum;
   public Integer between;
   public String etc;
}
