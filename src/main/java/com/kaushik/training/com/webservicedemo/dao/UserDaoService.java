package com.kaushik.training.com.webservicedemo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaushik.training.webservicedemo.domain.Users;

@Component
public class UserDaoService {

	private static List<Users> usersList = new ArrayList<>();

	private static int usersCount = 4;

	static {

		usersList.add(new Users(1, "Kaushik", LocalDate.now().minusYears(24)));
		usersList.add(new Users(2, "Durvas", LocalDate.now().minusYears(22)));
		usersList.add(new Users(3, "Princy", LocalDate.now().minusYears(23)));
	}

	public List<Users> findAll() {

		return usersList;

	}

	public Users findOneUser(int id) {

		for (Users users : usersList) {

			if (users.getUserId() == id) {

				return users;

			}
		}
		return null;
	}
	
	public void deleteById(int id) {
		
		Predicate<? super Users> predicate = users -> users.getUserId()== id;
		
		usersList.removeIf(predicate);
		
	}

	public Users save(Users users) {
		users.setUserId(++usersCount);
		usersList.add(users);

		return users;
	}

}
