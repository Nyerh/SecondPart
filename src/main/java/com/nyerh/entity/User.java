package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Integer uId;
    private String Username;
    private String Password;
    private String IdCard;
    private String uName;
    private String Phone;
    private String Sex;
    private String Address;
    private Integer CurRec;
    private Integer AllRec;
    private Integer AllOrder;

}
