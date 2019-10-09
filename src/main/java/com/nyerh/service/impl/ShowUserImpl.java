package com.nyerh.service.impl;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import com.nyerh.mapper.IUserShow;
import com.nyerh.service.ShowUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShowUserImpl implements ShowUserService {
    @Resource
    private IUserShow userShowMapper;
    @Override
    public User showUser(Integer uId) {
        User user = userShowMapper.showUser(uId);
        return user;
    }

    @Override
    public List<Demand> pastDemand(Integer uId) {
        List<Demand> demands = userShowMapper.pastDemand(uId);
        return demands;
    }

    @Override
    public List<Demand> orderRecord(Integer uId) {
        List<Demand> demands = userShowMapper.orderRecord(uId);
        return demands;
    }
}
