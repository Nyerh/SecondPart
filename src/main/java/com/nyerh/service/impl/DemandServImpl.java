package com.nyerh.service.impl;

import com.nyerh.entity.Demand;
import com.nyerh.mapper.IDemandMapper;
import com.nyerh.service.DemandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("DemandServImpl")
public class DemandServImpl implements DemandService {

    @Resource
    IDemandMapper idm;
    @Override
    public List<Demand> getList() {
        return idm.getList();
    }
}
