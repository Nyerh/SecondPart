package com.nyerh.controller;


import com.nyerh.entity.Send;
import com.nyerh.service.ISendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/send")
@Slf4j
public class SendController {
    @Resource
    private ISendService sendService;
    @RequestMapping(value = "/showSend",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Send> showSend(HttpSession session){
        Integer sid = (Integer) session.getAttribute("sid");
        List<Send> sends = sendService.showSend(sid);
        return sends;

    }

    @RequestMapping(value = "/save",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(Integer sid, HttpSession session){
        session.setAttribute("sid",sid);
    }
}
