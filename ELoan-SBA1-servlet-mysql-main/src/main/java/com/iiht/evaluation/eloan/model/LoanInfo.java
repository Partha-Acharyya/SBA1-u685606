package com.iiht.evaluation.eloan.model;

import java.util.UUID;

public class LoanInfo {
	private String applno;
	 private String purpose;
	 private String amtrequest;
	 private String doa;
	 private String bstructure;
	 private String bindicator;
	 private String address;
	 @Override
	public String toString() {
		return "LoanInfo [applno=" + applno + ", purpose=" + purpose + ", amtrequest=" + amtrequest + ", doa=" + doa
				+ ", bstructure=" + bstructure + ", bindicator=" + bindicator + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + ", status=" + status + ", TaxInd=" + TaxInd + "]";
	}
	private String email;
	 private String mobile;
	 private String status;
	 private String TaxInd;
	 
	 
	

	public LoanInfo() {
		 
	 }
	 public LoanInfo( String purpose, String amtrequest, String doa, String bstructure, String bindicator,
			String address, String email, String mobile,String status,String TaxInd) {
		super();
		
		this.purpose = purpose;
		this.amtrequest = amtrequest;
		this.doa = doa;
		this.bstructure = bstructure;
		this.bindicator = bindicator;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.status=status;
		this.TaxInd= TaxInd;
		
	}

	public String getApplno() {
		String applno = "";
		 try {
		 UUID uuid = UUID.randomUUID();
		 applno = uuid.toString();
		 } 
		 catch (Exception e) {
		 e.printStackTrace();
		 }
		return applno;
	}
	public void setApplno(String applno) {
		this.applno = applno;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getAmtrequest() {
		return amtrequest;
	}
	public void setAmtrequest(String amtrequest) {
		this.amtrequest = amtrequest;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getBstructure() {
		return bstructure;
	}
	public void setBstructure(String bstructure) {
		this.bstructure = bstructure;
	}
	public String getBindicator() {
		return bindicator;
	}
	public void setBindicator(String bindicator) {
		this.bindicator = bindicator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	public String getTaxInd() {
		return TaxInd;
	}
	public void setTaxInd(String taxInd) {
		TaxInd = taxInd;
	}
	
	

}
