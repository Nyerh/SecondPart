package com.nyerh.service.impl;

import com.nyerh.entity.Send;
import com.nyerh.mapper.ISendMapper;
import com.nyerh.service.ISendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SendServiceImpl")
public class SendServiceImpl implements ISendService {
    @Resource
    private ISendMapper iSendMapper;
    @Override
    public List<Send> showSend(Integer sid) {
        List<Send> sends = iSendMapper.showSend(sid);
        return sends;
    }
}
