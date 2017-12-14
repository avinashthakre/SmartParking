package com.infy.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADMIN_USERS")
public class AdminDetails extends StatusDetails {

	@Id
	@Column(name="USER_NAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	@JsonIgnore
	@Column(name="ROLE")
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminDetails [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}