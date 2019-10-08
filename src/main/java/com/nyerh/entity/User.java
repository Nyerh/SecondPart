package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Integer uId;
    private String username;
    private String password;
    private String idCard;
    private String uName;
    private String phone;
    private String sex;
    private String address;
    private Integer curRec;
    private Integer allRec;
    private Integer allOrder;
    private Integer detection;
}
