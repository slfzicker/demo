package com.cy.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class Roles implements Serializable{
   /**
	 * 角色实体类
	 */
	private static final long serialVersionUID = 1703588018930065746L;
   private Integer id;
   private String name;//角色名称
   private Date createdTime;//创建时间
   private Date modifiedTime;//修改时间
   private String createdUser;//创建用户
   private String modifiedUser;//修改用户
}
