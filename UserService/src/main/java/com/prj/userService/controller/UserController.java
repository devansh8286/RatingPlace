package com.prj.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User saveUser = userserviceImpl.saveUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);

	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {

		List<User> allUser = userserviceImpl.getAllUser();

		return ResponseEntity.status(HttpStatus.OK).body(allUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) {

		User user = userserviceImpl.getUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);

	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updateUser = userserviceImpl.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(updateUser);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		userserviceImpl.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body("User id : " + id + " Delete successfully");
	}

}
