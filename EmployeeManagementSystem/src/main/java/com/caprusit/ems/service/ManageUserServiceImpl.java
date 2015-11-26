package com.caprusit.ems.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.IManageUserDAO;
import com.caprusit.ems.domain.Employee;
@Service
public class ManageUserServiceImpl implements IManageUserService{
	
	@Autowired
	private IManageUserDAO  manageUserDAO;
	
	@Override
	public int addUser(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<Integer,Employee> viewUsers(int eid) {
		Map<Integer,Employee> map=manageUserDAO.viewUsers(eid);
		return map;
	} 

}
