/**
 * 
 */
package com.cloudconnected.common.security.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.security.model.User;
import com.cloudconnected.common.security.repository.UserRepository;




@Transactional(readOnly=true)
public class SecurityServiceImpl extends JdbcDaoImpl implements SecurityService {
	
	@Autowired
	private UserRepository userRepository;	
		
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		logger.debug("Entering with " + username);
		
		User user = userRepository.findByEmailAddress(username.toUpperCase());
		
		// Fault the relationship now. Later will cause ex-session lazy instantiation
		if(user != null) {
			user.getAuthorities();
		}
		
		return user;
	}

	
}	
	
