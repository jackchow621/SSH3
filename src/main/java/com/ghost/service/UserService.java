package com.ghost.service;

import java.io.Serializable;

import com.ghost.domain.Tuser;

public interface UserService {
	public void test();
	
	public Serializable save(Tuser tuser);
	
	public Tuser login(String name, String pwd);
}
