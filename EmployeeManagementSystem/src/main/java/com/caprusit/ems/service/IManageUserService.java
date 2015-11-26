package com.caprusit.ems.service;

import java.util.Map;

import com.caprusit.ems.domain.Employee;

public interface IManageUserService {

	public int addUser(Employee employee);
	public int updateUser(Employee employee);
	public Map<Integer,Employee> viewUsers(int eid); 
	
}
