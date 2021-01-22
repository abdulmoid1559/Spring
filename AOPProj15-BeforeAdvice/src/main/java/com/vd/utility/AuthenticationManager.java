package com.vd.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.bo.AccountBO;
import com.vd.dao.AuthenticationDAO;

@Service("authManager")
public class AuthenticationManager {
	private ThreadLocal<AccountBO> local=new ThreadLocal<AccountBO>();
	@Autowired
	private AuthenticationDAO dao;
	
	
	public void signIn(String username,String password) {
		AccountBO bo=null;

		bo=new AccountBO();
		System.out.println("AuthenticationManager.signIn()");
		bo.setUserName(username);
		bo.setPassword(password);
		local.set(bo);
	}
	public void signOut() {
		local.remove();
	}
	public boolean isAuthencate() {
		boolean flag=false;
		AccountBO bo=null;
		bo=local.get();
		flag=dao.validate(bo);
		return flag;
	}
}
