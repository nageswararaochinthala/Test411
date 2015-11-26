package com.caprusit.ems.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.ems.domain.Employee;
@Repository
public class ManageUserDAOImpl implements IManageUserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
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
	public Map<Integer, Employee> viewUsers(int eid) {
		Session session = sessionFactory.openSession();
		System.out.println("in daoimpl");
		String hql = "from  com.caprusit.ems.domain.Employee e  where e.employeeId=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, eid);
	
		List list = qry.list();
		Employee e=(Employee)list.get(0);
         Map<Integer,Employee> map=new HashMap();
           map.put(1, e);
		
		session.close(); 
		return map;
	}



}
