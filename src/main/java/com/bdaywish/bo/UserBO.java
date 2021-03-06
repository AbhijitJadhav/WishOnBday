package com.bdaywish.bo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Abhijit.Jadhav
 *
 */

public class UserBO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("date_of_birth")
	private Long dateOfBirth;
	
	private String email;
	
	private String phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
