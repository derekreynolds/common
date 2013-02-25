package com.cloudconnected.common.security.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.security.model.SecurityGroupAuthority;



/**
 * @author Derek Reynolds
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface SecurityGroupAuthorityRepository extends JpaRepository<SecurityGroupAuthority, Long> {

	Page<SecurityGroupAuthority> findBySecurityGroup_Id(Long securityGroupId, Pageable pageable);
	
}
