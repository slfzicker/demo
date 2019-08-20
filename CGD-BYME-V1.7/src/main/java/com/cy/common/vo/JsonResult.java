package com.cy.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -4075365183707025490L;
    /**
     * 1代表ok，0代表error
     */
	private int state=1;
	private String message="登录成功";
	private Object data;
	public JsonResult() {}
	public JsonResult(String message) {
		this.message=message;
	}
	public JsonResult(Object data) {
		this.data=data;
	}
	public JsonResult(Throwable e) {
		this.message=e.getMessage();
		this.state=0;
	}
}
