package com.nyerh.service;

public interface UserService {
    //获取当前用户的当前接单量
    Integer getCurRec(Integer uid);
    //获取当前用户的实名制状态值
    Integer getDetection(Integer uid);
    //接单时为当前用户的接单量+1
    Integer addCurRec(Integer uid);
}
