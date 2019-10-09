package com.nyerh.service;

import com.nyerh.entity.Send;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ISendService {
    List<Send> showSend(Integer sid);
}
