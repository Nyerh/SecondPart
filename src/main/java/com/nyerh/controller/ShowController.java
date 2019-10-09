package com.nyerh.controller;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import com.nyerh.service.ShowUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("ShowController")
@Slf4j
public class ShowController {
    @Resource
    private ShowUserService showUserImpl;

    //个人信息展示
    @RequestMapping(value = "show",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User show(HttpServletRequest request){
        Integer uId = (Integer)request.getSession().getAttribute("uid");

        User user = showUserImpl.showUser(uId);

        return user;
    }
    //历史需求展示
    @RequestMapping(value = "pastDemand",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Demand> pastDemand(HttpServletRequest request){
        Integer uId = (Integer)request.getSession().getAttribute("uid");

        List<Demand> demands = showUserImpl.pastDemand(uId);

        return demands;

    }
    //接单历史记录
    @RequestMapping(value = "orderRecord",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Demand> orderRecord(HttpServletRequest request){
        Integer uId = (Integer)request.getSession().getAttribute("uid");

        List<Demand> demands = showUserImpl.orderRecord(uId);

        return  demands;
    }


}
