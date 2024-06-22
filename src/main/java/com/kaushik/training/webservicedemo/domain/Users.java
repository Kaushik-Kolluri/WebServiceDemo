package com.kaushik.training.webservicedemo.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user_details")
public class Users {

	// why protected?
	protected Users() {

	}

	@Id
	@GeneratedValue
	private int userId;

//	@JsonProperty("user-name")
	private String userName;
	private LocalDate userDOB;

	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Posts> posts;

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

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userDOB=" + userDOB + ", posts=" + posts + "]";
	}

}
