package com.caprusit.ems.service;

import com.caprusit.ems.domain.Attendance;

public interface IAttendanceService {

	public boolean inTime(Attendance attendance);
	public boolean outTime(Attendance attendance);
}
