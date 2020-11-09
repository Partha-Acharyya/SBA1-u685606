package com.iiht.evaluation.eloan.model;

public class Adminuser {
	
	private String username;
	private String password;
	public Adminuser() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Adminuser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

}
