package com.nyerh.service.impl;

import com.nyerh.mapper.IUserMapper;
import com.nyerh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServImpl")
public class UserServImpl implements UserService {

    @Resource
    IUserMapper ium;

    @Override
    public Integer getCurRec(Integer uid) {
        return ium.getCurRec(uid);
    }

    @Override
    public Integer getDetection(Integer uid) {
        return ium.getDetection(uid);
    }
}
