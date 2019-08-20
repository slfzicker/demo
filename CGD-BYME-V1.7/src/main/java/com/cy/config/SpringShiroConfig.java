package com.cy.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
/**
 * 
 * @Configuration注解描述的类为一个配置对象
 * 此对象会交给spring管理
 *
 */
@Configuration

public class SpringShiroConfig {
	@Bean
   public SecurityManager  newSecurityManager(@Autowired Realm realm) {
		 DefaultWebSecurityManager sManager=
				 new DefaultWebSecurityManager();  
	   sManager.setRealm(realm);
	   return sManager;
   }
   
   @Bean("shiroFilterFactory")
   public ShiroFilterFactoryBean newShiroFilterFactoryBean(
		   @Autowired SecurityManager securityManager) {
			ShiroFilterFactoryBean sfBean = 
					new ShiroFilterFactoryBean();
			sfBean.setSecurityManager(securityManager);
			//假如没有认证请求先访问此认证的url
			sfBean.setLoginUrl("/doLoginUI");
			//定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
			Map<String, String> map=new LinkedHashMap<>();
			//静态资源允许匿名访问："anon"
			map.put("/css/**", "anon");
			map.put("/img/**", "anon");
			map.put("/js/**", "anon");
			map.put("/scss/**", "anon");
			map.put("/vendor/**", "anon");
			map.put("/user/doLogin", "anon");
			map.put("/doLogout", "logout");
			map.put("/favicon.ico", "anon");
			//除了匿名访问的资源，其它都要热认证“authc”后访问
			map.put("/**", "authc");//authc
			sfBean.setFilterChainDefinitionMap(map);
	   return sfBean;
   }
}
