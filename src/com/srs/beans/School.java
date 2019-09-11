package com.srs.beans;

public class School {
	private int schoolid;
	private String name;
	private String principal;
	private String email;
	private String address;
	private String locality;
	private int pin;
	private String city;
	private int seats;
	private String details;
	private String password;
	private String status;
	public School(){}
	public School(int schoolid, String name, String principal, String email,
			String address, String locality, int pin, String city, int seats,
			String details, String password, String status) {
		super();
		this.schoolid = schoolid;
		this.name = name;
		this.principal = principal;
		this.email = email;
		this.address = address;
		this.locality = locality;
		this.pin = pin;
		this.city = city;
		this.seats = seats;
		this.details = details;
		this.password = password;
		this.status = status;
	}
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "School [schoolid=" + schoolid + ", name=" + name
				+ ", principal=" + principal + ", email=" + email
				+ ", address=" + address + ", locality=" + locality + ", pin="
				+ pin + ", city=" + city + ", seats=" + seats + ", details="
				+ details + ", password=" + password + ", status=" + status
				+ "]";
	}
	
}
