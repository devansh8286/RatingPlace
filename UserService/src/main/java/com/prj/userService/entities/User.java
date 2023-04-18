package com.prj.userService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@ToString
public class User {

	@Id
	private String userId;
	private String name;
	private String email;
	private String about;

	@Transient
	private List<Rating> ratings = new ArrayList<>();

	public User(String userId, String name, String email, String about) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
