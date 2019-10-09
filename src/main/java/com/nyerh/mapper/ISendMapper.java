package com.nyerh.mapper;

import com.nyerh.entity.Send;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISendMapper {
    List<Send> showSend(@Param("sid") Integer sid);
}
