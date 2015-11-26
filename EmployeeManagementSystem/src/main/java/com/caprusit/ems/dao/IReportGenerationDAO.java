package com.caprusit.ems.dao;

import com.caprusit.ems.domain.Employee;

public interface IReportGenerationDAO {

	public Employee generateReportsByEmployeeId(int employeeId);
	public Employee generateReportsByDepartmentId(int deptId);
	public Employee generateReportsByOrganisation();
	
}
