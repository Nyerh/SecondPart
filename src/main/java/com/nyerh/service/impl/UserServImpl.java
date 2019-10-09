package com.nyerh.service.impl;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import com.nyerh.mapper.IUserMapper;
import com.nyerh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Integer addCurRec(Integer uid) {
        return ium.addCurRec(uid);
    }

    @Override
    public Integer userLogin(User user) {
        return ium.userLogin(user);
    }
    @Override
    public Integer userRegister(User user) {
        return ium.userRegister(user);
    }


    //——————————————————————————————————————————————————
    @Resource
    private IUserMapper userMapper;
    @Override
    public List<User> getUserById(Integer id) {
        List<User> list = userMapper.getUserById(id);
        return list;
    }

    @Override
    public Integer updateUser(User user) {
        Integer count = userMapper.updateUser(user);
        return count;
    }

    @Override
    public List<Demand> getAllOrder(Integer id) {
        List<Demand> list = userMapper.getAllOrder(id);
        return list;
    }

    @Override
    public Integer confirm(Integer gId) {
        Integer count = userMapper.confirm(gId);
        return count;
    }

}
