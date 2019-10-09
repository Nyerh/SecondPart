package com.nyerh.service;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;

import java.util.List;

public interface UserService {
    //获取当前用户的当前接单量
    Integer getCurRec(Integer uid);
    //获取当前用户的实名制状态值
    Integer getDetection(Integer uid);
    //接单时为当前用户的接单量+1
    Integer addCurRec(Integer uid);
    //用户登录
    Integer userLogin(User user);
    //用户注册
    Integer userRegister(User user);


    //修改时获取当前用户信息
    List<User> getUserById(Integer id);
    //修改保存更新用户信息
    Integer updateUser(User user);
    //获取已接单和已发布的订单信息
    List<Demand> getAllOrder(Integer id);
    //确认收货
    Integer confirm(Integer gId);
}
