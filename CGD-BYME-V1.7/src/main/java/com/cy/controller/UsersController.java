package com.cy.controller;

import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cy.common.vo.JsonResult;
import com.cy.entity.SysLog;
import com.cy.entity.Users;
import com.cy.service.UsersService;
import com.cy.utils.ExportExcelUtils;

@Controller
@RequestMapping("user/")
public class UsersController {
	@Autowired
	Realm realm;
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password) {
		//1.获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		//2.通过Subject提交用户信息,交给shiro框架进行认证操作
		//2.1对用户进行封装
		UsernamePasswordToken token = 
				new UsernamePasswordToken(username, password);
		//	token.setUsername(username);
		//token.setPassword(password.toCharArray());
		//if(isRememberMe)token.setRememberMe(true);
		//2.2对用户信息进行身份认证
		subject.login(token);

		return new JsonResult("login 成功");
	}
	/**
	 * 修改密码
	 */
	@Autowired
	private UsersService usersService;
	@RequestMapping("doUpdatePassword")
	@ResponseBody
	public JsonResult doUpdatePassword(
			String pwd,
			String newPwd,
			String cfgPwd) {
		usersService.updatePassword(pwd, newPwd, cfgPwd);
		return new JsonResult("update ok");
	}
	//	 @RequestMapping("pwd")
	//	 public String doindex() {
	//		 return "pwd_edit";
	//	 }

	@RequestMapping("doFindUsers")
	@ResponseBody
	public JsonResult doFindLog() {
		List<Users> result = usersService.selectUsers();
		System.out.println(result);
		return new JsonResult(result);
	}
	@RequestMapping("userList")
	public String douserList() {
		return "user_list";
	}


	@RequestMapping("userEdit")
	public String doUserEditUI(){
		return "pwd_edit";
	}

	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Users entity) {
		int saveObject = usersService.saveObject(entity);
		System.out.println("成功录入信息"+saveObject);
		return new JsonResult("save ok");

	}

	@RequestMapping("user_edit")
	public String doUsersEdit() {
		return "user_edit";

	}



	@RequestMapping(value = "/excel",method = RequestMethod.GET)
	public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
		//得到所有要导出的数据
		List<Users> errList = usersService.selectUsers();
              System.out.println("============"+errList);
		//定义导出的excel名字
		String excelName = "用户表";

		//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
		fieldMap.put("id","编号");
		fieldMap.put("username","姓名");
		fieldMap.put("password","密码");
		fieldMap.put("email", "邮箱");
		fieldMap.put("mobile", "电话");
System.out.println("****************************"+fieldMap);
		//导出用户相关信息
		new ExportExcelUtils().export(excelName,errList,fieldMap,response);
	}



}
