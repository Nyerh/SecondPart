package com.nyerh.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Manager {
    private Integer manaId;
    private String manaUsername;
    private String manaPassword;
}
