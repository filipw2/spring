package com.itemtracker.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itemtracker.auth.model.User;
import com.itemtracker.auth.model.UserDto;
import com.itemtracker.auth.repository.RoleRepository;
import com.itemtracker.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(UserDto userDto) {
		
		User user=new User();
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		
		user.setRole(roleRepository.findByName("USER"));
		userRepository.save(user);
	}
	@Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
