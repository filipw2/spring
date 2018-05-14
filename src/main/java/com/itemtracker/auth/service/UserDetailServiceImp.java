package com.itemtracker.auth.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itemtracker.auth.model.Role;
import com.itemtracker.auth.model.User;
import com.itemtracker.auth.repository.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByUsername(username);
		System.out.println(user.getUsername());
		String dBuserName = user.getUsername();
	    if(dBuserName == null){
	        throw new UsernameNotFoundException("User not authorized.");
	    }
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
