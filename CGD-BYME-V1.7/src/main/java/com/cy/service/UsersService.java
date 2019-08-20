package com.cy.service;

import java.util.List;

import com.cy.entity.Users;

public interface UsersService {
     /**
      * 保存用户名 
      * @param entity
      * @return
      */
	int saveObject(Users entity);

	int updatePassword(String password, String newPassword, String cfgPassword);

	/**
	 * 修改密码
	 * @param password 原密码
	 * @param newPassword 新密码(还没加密)
	 * @param cfgPassword 确认密码
	 * @return
	 */
	  /**
	   * 显示用户所有信息  
	   * @return
	   */
	 
	   List<Users>selectUsers();
	}
