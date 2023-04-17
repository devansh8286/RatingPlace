package com.prj.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.userService.entities.User;
import com.prj.userService.servicesImpl.UserserviceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserserviceImpl userserviceImpl;

	@PostMapping
	public User createUser(@RequestBody User user) {

		return userserviceImpl.saveUser(user);
	}

	@GetMapping
	public List<User> getAllUser() {

		return userserviceImpl.getAllUser();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) {

		return userserviceImpl.getUser(id);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userserviceImpl.updateUser(user);

	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		userserviceImpl.deleteUser(id);
		return "User deleted succesfully.. " + id;
	}

}
