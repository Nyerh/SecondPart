package com.nyerh.controller;

import com.nyerh.entity.User;
import com.nyerh.service.impl.UserServImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/UserLoginController")
@Slf4j
public class UserLoginController {
    @Resource
    UserServImpl userService;

    @RequestMapping("/Login")
    public Integer Login(@RequestBody User user, HttpSession httpSession)
    {
        Integer uid = userService.userLogin(user);
        if(uid!=null)
        {
            httpSession.setAttribute("uid",uid);
        }
        return uid;
    }
    @RequestMapping("/Register")
    public Integer Register(@RequestBody User user)
    {
        String idCard = user.getIdCard();
        String uName = user.getUName();
        if(idCard==null||uName==null)
        {
            user.setDetection(1);//未填写实名制信息
        }
        else
        {
            user.setDetection(2);//实名制审核中
        }
        Integer i = userService.userRegister(user);
        return i;
    }
}
