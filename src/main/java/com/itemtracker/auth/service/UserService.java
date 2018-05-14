package com.itemtracker.auth.service;

import com.itemtracker.auth.model.User;
import com.itemtracker.auth.model.UserDto;

public interface UserService {

	void save(UserDto user);

	User findByUsername(String username);

}
