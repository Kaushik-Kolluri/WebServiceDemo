package com.kaushik.training.webservicedemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Posts {

	@Id
	@GeneratedValue
	private int postId;

	private String postDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Users users;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	@JsonIgnore
	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", postDescription=" + postDescription + ", user=" + users + "]";
	}

}
