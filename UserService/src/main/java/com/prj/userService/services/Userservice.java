package com.prj.userService.services;

import java.util.List;

import com.prj.userService.entities.User;

public interface Userservice {

	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String userId);

	void deleteUser(String UserId);

	User updateUser(User user);

}
