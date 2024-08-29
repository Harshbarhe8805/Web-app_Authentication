package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class staff 
{
	@Id
	private String sid;
	private String sname;
	private String semail;
	private String spass;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	@Override
	public String toString() {
		return "staff [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", spass=" + spass + "]";
	}
	
	
}
