package com.nyerh.controller;

import ch.qos.logback.core.joran.action.ActionConst;
import com.nyerh.entity.Demand;
import com.nyerh.mapper.IDemandMapper;
import com.nyerh.service.impl.DemandServImpl;
import com.nyerh.service.impl.UserServImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/DemandController")
public class DemandController {

    @Resource
    DemandServImpl demandService;
    @Resource
    UserServImpl userService;


    @RequestMapping("/show")
    public List<Demand> show()//获取Demand的展示集合，内容为订单号/重量/数量/报价/存放点/目的地/下单时间/订单状态
    {
        return demandService.getList();
    }


    @RequestMapping("/detail")
    public Demand detail(@RequestBody(required = true) String gid)//获取Demand的详情，内容为订单号/重量/数量/报价/存放点/目的地/下单人/下单时间/里程数
    {
        int gId = Integer.parseInt(gid);
        return demandService.getDetail(gId);
    }

    @RequestMapping("/getDemand")
    public Integer getDemand(@RequestBody(required = true) String gid, HttpServletRequest req/*, HttpSession session*/)
    {
        int gId = Integer.parseInt(gid);
        /*Integer uid = (Integer) req.getSession().getAttribute("uid");*/
        Integer uid=1;
        Integer curRec = userService.getCurRec(uid);
        if(curRec>=3)
        {
            return 2;//状态值，同时接单数超过3
        }
        Integer detection = userService.getDetection(uid);
        if(detection!=3)
        {
            return 3;//状态值，未实名制
        }
        return demandService.getDemand(gId, uid);//状态值，0表示接单失败，1表示接单成功
    }
}
