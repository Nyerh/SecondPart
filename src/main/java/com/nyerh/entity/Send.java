package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Send {
    private Integer sId;
    private String sender;
    private String sendPhone;
    private String sendAdd;
    private String receiver;
    private String recPhone;
    private String recAdd;
}
