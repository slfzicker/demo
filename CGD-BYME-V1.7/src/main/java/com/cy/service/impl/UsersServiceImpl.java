package com.cy.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.dao.UsersDao;
import com.cy.entity.Users;
import com.cy.service.UsersService;
import com.cy.service.exception.ServiceException;




@Service
public class UsersServiceImpl implements UsersService{
     @Autowired
     private UsersDao usersDao;
	@Override
	public int saveObject(Users entity) {
		//1.验证数据合法性
		if(entity==null) {
			throw new ServiceException("保存对象不能为空");
		}
		if(StringUtils.isEmpty(entity.getUsername())) {
			throw new ServiceException("用户不能为空");
		}
		if(StringUtils.isEmpty(entity.getPassword())) {
			throw new ServiceException("密码不能为空");
		}
		
		//2.将数据写入数据库
		String salt = UUID.randomUUID().toString();
		entity.setSalt(salt);
		//加密
		SimpleHash sHash = 
				new SimpleHash("MD5", entity.getPassword(), salt);
		entity.setPassword(sHash.toHex());
		int rows = usersDao.insertObject(entity);
		return rows;
	}
	@Override
	public int updatePassword(String pwd, String newPwd, String cfgPwd) {
		if(StringUtils.isEmpty(newPwd))
			throw new IllegalArgumentException("新密码不能为空");
			if(StringUtils.isEmpty(cfgPwd))
			throw new IllegalArgumentException("确认密码不能为空");
			if(!newPwd.equals(cfgPwd))
			throw new IllegalArgumentException("两次输入的密码不相等");
			//2.判定原密码是否正确
			if(StringUtils.isEmpty(pwd))
			throw new IllegalArgumentException("原密码不能为空");
			//获取登陆用户
			Users user=(Users)SecurityUtils.getSubject().getPrincipal();
			SimpleHash sh=new SimpleHash("MD5",
			pwd, user.getSalt(), 1);
			if(!user.getPassword().equals(sh.toHex()))
			throw new IllegalArgumentException("原密码不正确");
			//3.对新密码进行加密
			String salt=UUID.randomUUID().toString();
			sh=new SimpleHash("MD5",newPwd,salt, 1);
			//4.将新密码加密以后的结果更新到数据库
			int rows=usersDao.updatePassword(sh.toHex(), salt,user.getId());
			if(rows==0)
			throw new ServiceException("修改失败");
			return rows;
	}
	@Override
	public List<Users> selectUsers() {
		List<Users> users = usersDao.selectUsers();
		return users;
	}
	

}
