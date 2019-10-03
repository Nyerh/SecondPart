package com.nyerh.controller;

import com.nyerh.entity.Demand;
import com.nyerh.mapper.IDemandMapper;
import com.nyerh.service.impl.DemandServImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/DemandController")
public class DemandController {

    @Resource
    DemandServImpl demandService;

    @RequestMapping("/show")
    public List<Demand> show()//获取Demand的展示集合，内容为订单号/重量/数量/报价/存放点/目的地/下单时间/订单状态
    {
        return demandService.getList();
    }
}
