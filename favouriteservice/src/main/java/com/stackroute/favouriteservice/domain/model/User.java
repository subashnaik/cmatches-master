package com.stackroute.favouriteservice.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

    @Id
    @Column(length = 30)
    private String userId;
    @Column(length = 20)
    private String userPassword;
    private String firstName;
    private String lastName;
    @Column(length = 30)
	private String userRole;
   
	public User() {
		
	}

	public User(String userId, String userPassword, String firstName, String lastName, String userRole) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userRole=" + userRole + "]";
	}
	

}
