package com.bdaywish.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author Abhijit.Jadhav
 *
 */
@Entity
@Table(name="users_meta")
public class UserMeta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(mappedBy="book",cascade=CascadeType.ALL)
	public User user;
	
	@Column
	public String profileImage;
	
	@Column
	public String address;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
