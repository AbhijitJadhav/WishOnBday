package com.bdaywish.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RBMailBean {
	
	@JsonProperty("emp_id")
	private Integer empId;
	private String subject;
	private String message;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
