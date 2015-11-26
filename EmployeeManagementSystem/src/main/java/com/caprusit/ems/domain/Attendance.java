package com.caprusit.ems.domain;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int attendanceId;
	private int employeeId;
	private Date attendanceDate;
	private Date startTime;
	private Date endTime;
	private double workingHours;
	private int  dayIndicator;
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	public int getDayIndicator() {
		return dayIndicator;
	}
	public void setDayIndicator(int dayIndicator) {
		this.dayIndicator = dayIndicator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", employeeId=" + employeeId + ", attendanceDate="
				+ attendanceDate + ", startTime=" + startTime + ", endTime=" + endTime + ", workingHours="
				+ workingHours + ", dayIndicator=" + dayIndicator + "]";
	}
	
	
	
	
}
