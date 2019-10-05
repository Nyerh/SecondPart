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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/DemandController")
public class DemandController {

    @Resource
    DemandServImpl demandService;
    @Resource
    UserServImpl userService;


    //展示页面
    @RequestMapping("/show")
    public List<Demand> show()//获取Demand的展示集合，内容为订单号/重量/数量/报价/存放点/目的地/下单时间/订单状态
    {
        return demandService.getList();
    }

    //详情页
    @RequestMapping("/detail")
    public Demand detail(@RequestBody(required = true) String gid)//获取Demand的详情，内容为订单号/重量/数量/报价/存放点/目的地/下单人/下单时间/里程数
    {
        int gId = Integer.parseInt(gid);
        return demandService.getDetail(gId);
    }
    //接单
    @RequestMapping("/getDemand")
    public Integer getDemand(@RequestBody(required = true) String gid, HttpServletRequest req/*, HttpSession session*/)
    {
        int gId = Integer.parseInt(gid);
        //获取当前用户uid
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
        Integer demand = demandService.getDemand(gId, uid);//状态值，0表示接单失败，1表示接单成功
        if(demand==1)
        {
            userService.addCurRec(uid);
            return 1;
        }
        return 0;
    }
    //下单
    @RequestMapping("/order")
    public Integer order(@RequestBody Demand demand, HttpServletRequest req)
    {
        //获取当前用户uid
        /*Integer uid = (Integer) req.getSession().getAttribute("uid");*/
        Integer uid=1;
        demand.setOrderUId(uid);
        demand.setState("non");
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        demand.setCurTime(dateFormat.format(date));
        Integer detection = userService.getDetection(uid);
        if(detection!=3)
        {
            return 3;//状态值，未实名制
        }
        Integer i = demandService.addDemand(demand);
        return i;
    }
}
