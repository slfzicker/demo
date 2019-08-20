package com.cy.entity;

import lombok.Data;

@Data
public class LoginModel {
	private String sessionId;
    private String sig;
    private String token;
    private String scene;
    private String appKey;
    private String remoteIp;
    private String phone;
    private String password;

}
