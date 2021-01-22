package com.vd.utility;

import org.springframework.beans.BeanUtils;

import com.vd.bo.AccountBO;
import com.vd.dao.AuthenticationDAO;
import com.vd.dto.AccountDTO;


public class AuthenticationManager {
	private ThreadLocal<AccountBO> local=new ThreadLocal<AccountBO>();
	private AuthenticationDAO dao=null;
	
	public AuthenticationManager(AuthenticationDAO dao) {
		
		this.dao = dao;
	}
	public void signIn(String username,String password) {
		AccountBO bo=null;
		
		bo=new AccountBO();
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
