package com.engseen.erp.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    private String userId;

    private String password;

}
