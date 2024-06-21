package com.kaushik.training.webservicedemo.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
 

@Entity(name = "user_details")
public class Users {
	
	//why protected?
	protected Users() {
		
	}

	@Id
	@GeneratedValue
	private int userId;
	
//	@JsonProperty("user-name")
	private String userName;
	private LocalDate userDOB;

	public Users(int userId, String userName, LocalDate userDOB) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userDOB = userDOB;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(LocalDate userDOB) {
		this.userDOB = userDOB;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userDOB=" + userDOB + "]";
	}

}
