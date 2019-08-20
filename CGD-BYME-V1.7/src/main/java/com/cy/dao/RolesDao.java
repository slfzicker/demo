package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.entity.Roles;

@Mapper
public interface RolesDao {
	/**
	   * 分页查询
	 * @param name 
	 * @param startIndex 上一页的结束位置
	 * @param pageSize  每页要查询的记录数
	 * @return
	 */
	List<Roles> findPageObjects(@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize); 
	
	/**
	 * 查询记录总数
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	
	/**
	 *  添加角色数据
	 * @param entity
	 * @return
	 */
	
	int insertRoles(Roles entity);

}
