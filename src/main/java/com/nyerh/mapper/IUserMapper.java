package com.nyerh.mapper;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {
    //获取当前用户的当前接单量
    Integer getCurRec(@Param("uId") Integer uid);
    //获取当前用户的实名制状态值
    Integer getDetection(@Param("uId") Integer uid);
    //接单时为当前用户的接单量+1
    Integer addCurRec(@Param("uId") Integer uid);
    //用户登录
    Integer userLogin(@Param("user") User user);
    //用户注册
    Integer userRegister(@Param("user") User user);

    //修改时获取当前用户信息
    List<User> getUserById(@Param("uId") Integer id);
    //保存用户修改信息，更新用户信息
    Integer updateUser(@Param("user") User user);
    //获取已接单和发布的订单信息
    List<Demand> getAllOrder(@Param("uId") Integer id);
    //确认收货
    Integer confirm(@Param("gId") Integer gId);
}
