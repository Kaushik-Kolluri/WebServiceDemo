package com.kaushik.training.webservicedemo.resources;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kaushik.training.com.webservicedemo.dao.UserDaoService;
import com.kaushik.training.webservicedemo.domain.Users;
import com.kaushik.training.webservicedemo.exceptions.UserNotFoundException;

@RestController
public class UserResource {

	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {

		this.userDaoService = userDaoService;
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {

		return userDaoService.findAll();

	}

	@GetMapping("/users/{userId}")
	public Users getUserById(@PathVariable int userId) {

		Users users = userDaoService.findOneUser(userId);

		if (users == null) {

			throw new UserNotFoundException("User not found");

		}

		return users;

	}

	@DeleteMapping("/users/delete/{userId}")
	public void deleteUserById(@PathVariable int userId) {

		userDaoService.deleteById(userId);

	}

	@PostMapping("/users/save")
	public ResponseEntity<Users> createUser(@RequestBody Users user) {

		Users savedUser = userDaoService.save(user);

		// the below code displays the intended http response codes (201 if success.)
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	

}
