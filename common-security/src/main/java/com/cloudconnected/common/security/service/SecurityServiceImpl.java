/**
 * 
 */
package com.cloudconnected.common.security.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.security.model.User;
import com.cloudconnected.common.security.repository.UserRepository;


@Transactional(readOnly=true)
@Service("securityService")
public class SecurityServiceImpl implements SecurityService {
	
	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;	
		
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		logger.debug("Entering with " + username);
		
		Optional<User> user = userRepository.findByEmailAddress(username.toLowerCase());
		
		// Fault the relationship now. Later will cause ex-session lazy instantiation
		if(user.isPresent() && (user.get().getAuthorities().size() == 0)) 
			throw new UsernameNotFoundException(username + " no authorities found.");		
		
		return user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
	}

	
}	
	
