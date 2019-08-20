package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.entity.WareHouse;

@Mapper
public interface WareHouseDao {
	/**
	 * 查询仓库所有信息
	 * @return
	 */
	@Select("select * from warehouse")
      List<WareHouse> selectWareHouse();
}
