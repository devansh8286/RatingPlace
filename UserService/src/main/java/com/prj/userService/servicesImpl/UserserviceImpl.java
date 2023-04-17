package com.prj.userService.servicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.userService.entities.User;
import com.prj.userService.exceptions.ResourceNotFoundException;
import com.prj.userService.repositories.UserRepository;
import com.prj.userService.services.Userservice;

@Service
public class UserserviceImpl implements Userservice {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		UUID uuid = UUID.randomUUID();
		String randomUserId = uuid.toString();

		user.setUserId(randomUserId);

		User savedUser = userRepository.save(user);

		return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public User getUser(String userId) {

		User userFound = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given Id : " + userId + " Not found !!"));
		return userFound;
	}

	@Override
	public void deleteUser(String UserId) {
		User userFound = userRepository.findById(UserId).orElseThrow(() -> new ResourceNotFoundException(
				"User with given Id : " + UserId + " Not found for Delete!!"));
		userRepository.deleteById(UserId);

	}

	@Override
	public User updateUser(User user) {

		User userFound = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException(
				"User with given Id : " + user.getUserId() + " Not found for modify!!"));
		User UpdatedUser = userRepository.save(user);

		return UpdatedUser;
	}

}
