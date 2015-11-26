package com.caprusit.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.ISecurityDAO;
import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

@Service
public class SecurityServiceImpl implements ISecurityService{
	
	@Autowired
	private ISecurityDAO  securityDAO;
	
	@Override
	public String login(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPassword(Admin admin, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(Admin admin) {
		String msg=securityDAO.changePassword(admin);
		return msg;
	}
}
