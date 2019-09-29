package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Integer u_id;
    private String username;
    private String password;
    private String id_card;
    private String u_name;
    private String phone;
    private String sex;
    private String address;
    private Integer cur_rec;
    private Integer all_rec;
    private Integer all_order;

}
