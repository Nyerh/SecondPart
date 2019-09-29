package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Send {
    private String s_id;
    private String sender;
    private String send_phone;
    private String send_add;
    private String receiver;
    private String rec_phone;
    private String rec_add;

}
