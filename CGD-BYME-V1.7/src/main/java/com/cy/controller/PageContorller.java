package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageContorller {
	//主页面
	@RequestMapping("doIndex")
	public String doIndex() {
		return "index";
	}
	//登录页面
	@RequestMapping("doLoginUI")
	public String doLogin() {
		return "login";
	}
	@RequestMapping("user_edit")
	public String user_edit() {
		return "user_edit";
	}
	@RequestMapping("doUpdatePwd")
	public String doUpdatePwd() {
		return "pwd_edit";
	}
	@RequestMapping("log_list")
	public String dolog_list() {
		return "log_list";
	}
	@RequestMapping("user_list")
	public String douser_list() {
		return "user_list";
	}
	@RequestMapping("test")
	public String dotest() {
		return "test";
	}
//	@RequestMapping("index")
//	public String index() {
//		return "index";
//	}
	

}
