package com.nyerh.controller;

import com.nyerh.entity.Demand;
import com.nyerh.entity.Manager;
import com.nyerh.entity.User;
import com.nyerh.service.impl.DemandServImpl;
import com.nyerh.service.impl.ManagerSerImpl;
import com.nyerh.service.impl.UserServImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ManagerController")
public class ManagerController {

    @Resource
    ManagerSerImpl managerService;

    @RequestMapping("/manaLogin")
    public Integer manaLogin(@RequestBody Manager manager)
    {
        return managerService.manaLogin(manager);
    }
    @RequestMapping("/showDemand")
    public List<Demand> showDemand()//获取Demand的全部信息
    {
        return managerService.getListD();
    }
    @RequestMapping("/showUser")
    public List<User> showUser()//获取User的全部信息
    {
        return managerService.getListU();
    }
    @RequestMapping("/showUserD2")
    public List<User> showUserD2()//获取User审核中信息
    {
        return managerService.getListD2();
    }

    @RequestMapping("/delDemand")
    public Integer delDemand(@RequestBody String gid)//删除订单
    {
        int gId = Integer.parseInt(gid);
        return managerService.delDemand(gId);
    }

    @RequestMapping("/delUser")
    public Integer delUser(@RequestBody String uid)//删除用户
    {
        int uId = Integer.parseInt(uid);
        return managerService.delUser(uId);
    }

    @RequestMapping("/detecUser")
    public Integer detecUser(@RequestBody String uid)//审核用户
    {
        int uId = Integer.parseInt(uid);
        return managerService.detecUser(uId);
    }

}
