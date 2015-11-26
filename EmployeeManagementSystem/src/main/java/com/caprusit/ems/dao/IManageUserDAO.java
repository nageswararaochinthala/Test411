package com.caprusit.ems.dao;

import java.util.Map;

import com.caprusit.ems.domain.Employee;

public interface IManageUserDAO {

	public int addUser(Employee employee);
	public int updateUser(Employee employee);
	public Map<Integer,Employee> viewUsers(int eid); 
	
	
}
