package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.entity.Users;

@Mapper
public interface UsersDao {
	/**
	 * 负责添加用户信息写入到数据库
	 * @param entity
	 * @return
	 */
     int insertObject(Users entity);
    /**
     * 根据用户名查询用户对象的方法
     * @param username
     * @return
     */
     @Select("select * from users where username=#{username}")
     Users findUserByUserName(String username);
     /**
 	 * 基于用户id修改用户的密码
 	 * @param password 新的密码
 	 * @param salt 密码加密时使用的盐值
 	 * @param id 用户id
 	 * @return
 	 */
 	int updatePassword(
 			@Param("password")String password,
 			@Param("salt")String salt,
 			@Param("id")Integer id);
 	/**
 	 * 查询所有用户信息
 	 * @return
 	 */
 	@Select("select id,username,email,mobile,valid,createdTime,"
 			+ "modifiedTime from users")
 	List<Users>selectUsers();
}
