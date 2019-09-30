package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Demand {
   public Integer gId;
   public Integer OrderUId;
   public Integer RecUId;
   public Double Weight;
   public Integer Num;
   public Double Price;
   public String Origin;
   public String Target;
   public String State;
   public String CurTime;
   public String TrackNum;
   public Integer Between;
   public String Etc;
}
