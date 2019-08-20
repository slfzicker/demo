package com.cy.service;

import com.cy.common.vo.PageObject;
import com.cy.entity.Roles;

public interface RoleService {
	 /**
              * 本方法中要分页查询角色信息,并查询角色总记录数据
     * @param pageCurrent 当表要查询的当前页的页码值
     * @return 封装当前实体数据以及分页信息
     */
	PageObject<Roles> findPageObjects();
}
