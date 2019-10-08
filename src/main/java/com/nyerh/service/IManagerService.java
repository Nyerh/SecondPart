package com.nyerh.service;

import com.nyerh.entity.Demand;
import com.nyerh.entity.Manager;
import com.nyerh.entity.User;

import java.util.List;


public interface IManagerService {
    //管理员登录
    Integer manaLogin(Manager manager);
    //展示所有订单
    List<Demand> getListD();
    //展示所有用户
    List<User> getListU();
    //展示审核中用户
    List<User> getListD2();
    //删除订单
    Integer delDemand(Integer gid);
    //删除用户
    Integer delUser(Integer uid);
    //审核用户
    Integer detecUser(Integer uid);
}
