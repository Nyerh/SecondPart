package com.nyerh.service.impl;

import com.nyerh.entity.Demand;
import com.nyerh.entity.Manager;
import com.nyerh.entity.User;
import com.nyerh.mapper.IManagerMapper;
import com.nyerh.service.IManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ManagerSerImpl")
public class ManagerSerImpl implements IManagerService {

    @Resource
    IManagerMapper iManagerMapper;

    @Override
    public Integer manaLogin(Manager manager) {
        return iManagerMapper.manaLogin(manager);
    }

    @Override
    public List<Demand> getListD() {
        return iManagerMapper.getListD();
    }

    @Override
    public List<User> getListU() {
        return iManagerMapper.getListU();
    }

    @Override
    public List<User> getListD2() {
        return iManagerMapper.getListD2();
    }

    @Override
    public Integer delDemand(Integer gid) {
        return iManagerMapper.delDemand(gid);
    }

    @Override
    public Integer delUser(Integer uid) {
        return iManagerMapper.delUser(uid);
    }

    @Override
    public Integer detecUser(Integer uid) {
        return iManagerMapper.detecUser(uid);
    }
}
