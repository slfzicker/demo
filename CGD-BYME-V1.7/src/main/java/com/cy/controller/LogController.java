package com.cy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.vo.JsonResult;
import com.cy.entity.SysLog;
import com.cy.entity.Users;
import com.cy.service.SysLogService;
import com.cy.utils.ExportExcelUtils;
@Controller
@RequestMapping("/")
public class LogController {
	@Autowired
	 private SysLogService sysLogService;
//	 
//	 @RequestMapping("doFindPageObjects")
//	 @ResponseBody
//	 public JsonResult doFindPageObjects(String username,Integer pageCurrent){
//	  PageObject<SysLog> pageObject=
//	  sysLogService.findPageObjects(username,pageCurrent);
//	 return new JsonResult(pageOject);
//	 }
	 @RequestMapping("doFindLog")
	 @ResponseBody
	 public JsonResult doFindLog() {
	  List<SysLog> result = sysLogService.dofindObject();
	  System.out.println(result);
	  return new JsonResult(result);
	 }
	 @RequestMapping("tables")
	 public String doTables() {
		 return "tables";
	 }
	 @RequestMapping("index")
	 public String doindex() {
		 return "index";
	 }

		@RequestMapping(value = "SysLogexcel",method = RequestMethod.GET)
		public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
			//得到所有要导出的数据
			List<SysLog> errList = sysLogService.dofindObject();
	              System.out.println("============"+errList);
			//定义导出的excel名字
			String excelName = "日志表";

			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
			fieldMap.put("id","编号");
			fieldMap.put("username","用户名");
			fieldMap.put("operation","操作");
			
			fieldMap.put("method","请求方法");
			fieldMap.put("params", "请求参数");
			fieldMap.put("time", "次数");
			fieldMap.put("ip", "ip地址");
			fieldMap.put("createdTime", "执行时间");
	System.out.println("****************************"+fieldMap);
			//导出用户相关信息
			new ExportExcelUtils().export(excelName,errList,fieldMap,response);
		}
}
