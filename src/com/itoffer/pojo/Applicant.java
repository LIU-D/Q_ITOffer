package com.itoffer.pojo;

public class Applicant {

	private int  id;
	private	String	 email;
	private	String   password;
	private	String   timestamp;
	
	public Applicant(){
		
	}
	
	public Applicant(int applicantId, String email, String password){
		this.id = applicantId;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
