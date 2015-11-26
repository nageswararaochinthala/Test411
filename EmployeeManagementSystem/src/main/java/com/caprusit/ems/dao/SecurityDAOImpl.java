package com.caprusit.ems.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

@Repository
public class SecurityDAOImpl implements ISecurityDAO {
	@Autowired
	private SessionFactory sessionFactory;

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
		Session session = sessionFactory.openSession();
		System.out.println("in daoimpl");
		System.out.println("change done12");
		String hql = "update com.caprusit.ems.domain.Admin as a set a.password=? where a.adminId=10230";
		Query query = session.createQuery(hql);
		query.setParameter(0, admin.getPassword());
		// query.setParameter(1, admin.getAdminId());
		Transaction ts = session.beginTransaction();
		int count = query.executeUpdate();
		ts.commit();	

		session.close();
		
		if (count != 0)
			return "your password changed successfully";
		else
			return "oops some problem occurs, you cannot change the password. Try again...... ";
		
	}

}
