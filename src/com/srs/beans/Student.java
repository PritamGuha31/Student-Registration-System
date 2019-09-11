package com.srs.beans;

public class Student {
	private int roll;
	private String cname;
	private String fname;
	private String mname;
	private String dob;
	private String gender;
	private String category;
	private String nation;
	private int aif;
	private String caddress;
	private String district;
	private String state;
	private String cemail;
	private long cphone;
	private long caadhar;
	private String cpass;
	private String secqtn;
	private String secans;
	private String picture;
	public Student() {}
	
	public Student(int roll, String cname, String fname, String mname,
			String dob, String gender, String category, String nation, int aif,
			String caddress, String district, String state, String cemail,
			long cphone, long caadhar, String cpass, String secqtn,
			String secans, String picture) {
		super();
		this.roll = roll;
		this.cname = cname;
		this.fname = fname;
		this.mname = mname;
		this.dob = dob;
		this.gender = gender;
		this.category = category;
		this.nation = nation;
		this.aif = aif;
		this.caddress = caddress;
		this.district = district;
		this.state = state;
		this.cemail = cemail;
		this.cphone = cphone;
		this.caadhar = caadhar;
		this.cpass = cpass;
		this.secqtn = secqtn;
		this.secans = secans;
		this.picture=picture;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getAif() {
		return aif;
	}
	public void setAif(int aif) {
		this.aif = aif;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public long getCphone() {
		return cphone;
	}
	public void setCphone(long cphone) {
		this.cphone = cphone;
	}
	public long getCaadhar() {
		return caadhar;
	}
	public void setCaadhar(long caadhar) {
		this.caadhar = caadhar;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getSecqtn() {
		return secqtn;
	}
	public void setSecqtn(String secqtn) {
		this.secqtn = secqtn;
	}
	public String getSecans() {
		return secans;
	}
	public void setSecans(String secans) {
		this.secans = secans;
	}
	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", cname=" + cname + ", fname="
				+ fname + ", mname=" + mname + ", dob=" + dob + ", gender="
				+ gender + ", category=" + category + ", nation=" + nation
				+ ", aif=" + aif + ", caddress=" + caddress + ", district="
				+ district + ", state=" + state + ", cemail=" + cemail
				+ ", cphone=" + cphone + ", caadhar=" + caadhar + ", cpass="
				+ cpass + ", secqtn=" + secqtn + ", secans=" + secans
				+ "]";
	}
	
}
