package com.caprusit.ems.service;

import com.caprusit.ems.domain.Employee;

public interface IReportGenerationService {
	
	public Employee generateReportsByEmployeeId(int employeeId);
	public Employee generateReportsByDepartmentId(int deptId);
	public Employee generateReportsByOrganisation();
	
}
