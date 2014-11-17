package com.cloudconnected.common.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.security.model.User;


/**
 * @author Derek Reynolds
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailAddress(String emailAddress);
	
}
