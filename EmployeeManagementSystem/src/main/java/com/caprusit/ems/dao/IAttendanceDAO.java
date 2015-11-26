package com.caprusit.ems.dao;

import com.caprusit.ems.domain.Attendance;

public interface IAttendanceDAO {

	public boolean inTime(Attendance attendance);
	public boolean outTime(Attendance attendance);
}
