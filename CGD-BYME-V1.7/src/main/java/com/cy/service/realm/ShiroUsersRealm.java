package com.cy.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.UsersDao;
import com.cy.entity.Users;
@Service
public class ShiroUsersRealm extends AuthorizingRealm {
    @Autowired
   private UsersDao usersDao;
    /**
     * 设置凭证匹配器（与用户添加操作使用相同的加密算法MD5
     */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//构建凭证匹配对象
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		//设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}
    
    /**
     * 认证管理，底层会将认证数据传递认证管理器，有认证管理器完成认证操作
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取用户名(用户页面输入)
		     UsernamePasswordToken upToken= (UsernamePasswordToken) token;
		     String username=upToken.getUsername();
		//2.基于用户名查询用户信息
		     Users user = usersDao.findUserByUserName(username);
		//3.判定用户是否存在
		     if(user==null) {
		    	 throw new UnknownAccountException();
		     }
		//4.判定用户是否已被禁用。
//		     if(user.getValid()==0) {
//		    	 throw new LockedAccountException();
//		     }
		//5.封装用户信息
		     ByteSource credentialsSalt= 
		    		 ByteSource .Util.bytes(user.getSalt());
		     SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,//principal, 账号
		    		                      user.getPassword() ,//hashedCredentials, 密码
		    		              credentialsSalt, 
		    		         getName());// realmName 域名
		//6.返回封装结果
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
