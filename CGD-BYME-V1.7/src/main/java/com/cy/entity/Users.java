package com.cy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class Users implements Serializable{
	/**
	 * 用户实体类
	 */
	private static final long serialVersionUID = -3347950523862389349L;
	private Integer id;//
	@NotBlank(message = "username can not be null")
	private String username;//用户名
    private String password;//密码
    private String salt;//盐值
    @Email
	@NotBlank(message = "email can not be null")
	private String email;//邮箱
	private String mobile;//手机号
	private Integer valid=1;//状态  0：禁用   1：正常  默认值
    private Date createdTime;//创建时间
    private Date modifiedTime;//修改时间
    
}
