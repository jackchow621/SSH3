package com.ghost.test;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ghost.domain.Tuser;
import com.ghost.service.UserService;

public class HibernateTest {/*
	private static final Logger logger = Logger.getLogger(HibernateTest.class);
	@Test
	public void test(){
		logger.info("==========HibernateTest=============");
		ApplicationContext ac =  new ClassPathXmlApplicationContext
		(new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
		UserService userService =(UserService)ac.getBean("userService");
		Tuser tuser = new Tuser();
		tuser.setCreatedatetime(new Date());
		tuser.setId(UUID.randomUUID().toString());
		tuser.setModifydatetime(new Date());
		tuser.setName("admin");
		tuser.setPwd("123");
		userService.save(tuser);
	}
*/}
