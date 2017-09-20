package com.ghost.action;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ghost.domain.Tuser;
import com.ghost.service.UserService;
import com.ghost.util.Encrypt;

@ParentPackage("basePackage")
@Namespace("/")

public class UserAction {
	private UserService userService;
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private String username;
	private String password;
	public void test(){
		logger.info("=======UserAction=========");
		/*ApplicationContext ac = 
		 WebApplicationContextUtils.getWebApplicationContext
		(ServletActionContext.getServletContext());
		UserService userService =(UserService)ac.getBean("userService");
		userService.test();*/
		userService.test();
	}
	
	//注册
	@Action(value="register")
	public void save(){
		logger.info("=======UserAction-save=========");
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write("OK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(username+"\t"+password);
		
		Tuser tuser = new Tuser();
		tuser.setCreatedatetime(new Date());
		tuser.setId(UUID.randomUUID().toString());
		tuser.setModifydatetime(new Date());
		tuser.setName(username);
		tuser.setPwd(Encrypt.e(password));
		userService.save(tuser);
	}
	
	//登录
	//@Action(value="login",results={@Result(name="success",location="/login.jsp"),@Result(name="error",location="/register.jsp")})
	@Action(value="login")
	public void login(){
		System.out.println(username+"\t"+password);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		//访问业务层的登录方法
		Tuser tuser =  userService.login(username, Encrypt.e(password));
		try {
			if(tuser!=null){
				ServletActionContext.getResponse().getWriter().write("OK");
			}else{
				ServletActionContext.getResponse().getWriter().write("NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
