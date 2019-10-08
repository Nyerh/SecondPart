package com.nyerh.mapper;

import com.nyerh.entity.Demand;
import com.nyerh.entity.Manager;
import com.nyerh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IManagerMapper {
    //管理员登录
    Integer manaLogin(@Param("manager") Manager manager);
    //展示所有订单
    List<Demand> getListD();
    //展示所有用户
    List<User> getListU();
    //展示审核中用户
    List<User> getListD2();
    //删除订单
    Integer delDemand(@Param("gid") Integer gid);
    //删除用户
    Integer delUser(@Param("uid") Integer uid);
    //审核用户
    Integer detecUser(@Param("uid") Integer uid);

}
