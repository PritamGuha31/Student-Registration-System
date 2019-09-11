package com.srs.beans;

public class ExamRegistry {
	private int eid;
	private Student student;
	private String tenboard;
	private int tenyear;
	private String tenmarks;
	private String twelveboard;
	private int twelveyear;
	private String twelvemarks;
	private School school;
	
	public ExamRegistry(){}

	public ExamRegistry(int eid, Student student, String tenboard, int tenyear,
			String tenmarks, String twelveboard, int twelveyear,
			String twelvemarks, School school) {
		super();
		this.eid = eid;
		this.student = student;
		this.tenboard = tenboard;
		this.tenyear = tenyear;
		this.tenmarks = tenmarks;
		this.twelveboard = twelveboard;
		this.twelveyear = twelveyear;
		this.twelvemarks = twelvemarks;
		this.school = school;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTenboard() {
		return tenboard;
	}

	public void setTenboard(String tenboard) {
		this.tenboard = tenboard;
	}

	public int getTenyear() {
		return tenyear;
	}

	public void setTenyear(int tenyear) {
		this.tenyear = tenyear;
	}

	public String getTenmarks() {
		return tenmarks;
	}

	public void setTenmarks(String tenmarks) {
		this.tenmarks = tenmarks;
	}

	public String getTwelveboard() {
		return twelveboard;
	}

	public void setTwelveboard(String twelveboard) {
		this.twelveboard = twelveboard;
	}

	public int getTwelveyear() {
		return twelveyear;
	}

	public void setTwelveyear(int twelveyear) {
		this.twelveyear = twelveyear;
	}

	public String getTwelvemarks() {
		return twelvemarks;
	}

	public void setTwelvemarks(String twelvemarks) {
		this.twelvemarks = twelvemarks;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "ExamRegistry [eid=" + eid + ", student=" + student
				+ ", tenboard=" + tenboard + ", tenyear=" + tenyear
				+ ", tenmarks=" + tenmarks + ", twelveboard=" + twelveboard
				+ ", twelveyear=" + twelveyear + ", twelvemarks=" + twelvemarks
				+ ", school=" + school + "]";
	}
	
	
}
