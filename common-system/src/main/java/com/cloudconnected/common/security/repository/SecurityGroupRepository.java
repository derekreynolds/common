package com.cloudconnected.common.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.security.model.SecurityGroup;



/**
 * @author Derek Reynolds
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface SecurityGroupRepository extends JpaRepository<SecurityGroup, Long> {

	public SecurityGroup findByGroupName(String groupName);
}
