package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Send {
    private Integer sId;
    private String Sender;
    private String SendPhone;
    private String SendAdd;
    private String Receiver;
    private String RecPhone;
    private String RecAdd;
}
