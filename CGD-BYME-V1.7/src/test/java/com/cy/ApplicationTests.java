package com.cy;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.dao.RolesDao;
import com.cy.dao.UsersDao;
import com.cy.dao.WareHouseDao;
import com.cy.entity.Roles;
import com.cy.entity.Users;
import com.cy.entity.WareHouse;
import com.cy.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	DataSource dataSource;
	@Test//测试连接池
	public void contextLoads() throws Exception {
		Connection conn = dataSource.getConnection();
		System.out.println(conn);

	}
	@Autowired
	WareHouseDao wareHouseDao;
	@Test
	public void selectwarehouse() {
		List<WareHouse> rows = wareHouseDao.selectWareHouse();
		System.out.println("rows="+rows);
	}
	@Autowired
	UsersService usersService;
	/**
	 * 测试新建用户
	 */
	@Test
	public void insertUsers() {
		Users entity = new Users();
		entity.setUsername("ABC");
		entity.setPassword("123456");
		int orws = usersService.saveObject(entity);
		System.out.println(orws);
	}
	/**
	 * 测试角色创建
	 */
	@Autowired
	RolesDao rolesDao;
    @Test
    public void innsertRoles() {
    	Roles roles = new Roles();
    	roles.setName("店长");
    	int rows = rolesDao.insertRoles(roles);
    	System.out.println("roles="+roles);
    }







}