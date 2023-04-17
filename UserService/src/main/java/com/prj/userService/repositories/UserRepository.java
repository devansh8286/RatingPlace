package com.prj.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.userService.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
