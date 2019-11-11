package com.stackroute.userservice.domain.dto;


public class UserDTO {

    private String userId;
    private String userPassword;
    private String firstName;
    private String lastName;
	private String mail;
   
	public UserDTO() {
		
	}

	public UserDTO(String userId, String userPassword, String firstName, String lastName, String mail) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + mail + "]";
	}
	

}
