package com.srs.beans;

public class Admin {
	private String adminid;
	private String adminpass;
	
	public Admin() {}

	public Admin(String adminid, String adminpass) {
		super();
		this.adminid = adminid;
		this.adminpass = adminpass;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpass() {
		return adminpass;
	}

	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminpass=" + adminpass + "]";
	}
	
	
}
