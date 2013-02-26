/**
 * 
 */
package com.cloudconnected.common.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudconnected.common.security.model.SecurityGroup;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
public interface SecurityGroupService {

	public void save(SecurityGroup securityGroup);
	
	public void delete(SecurityGroup securityGroup);
	
	public Page<SecurityGroup> getSecurityGroups(Pageable pageable);
	
	public SecurityGroup getById(Long id);
	
	public SecurityGroup getByGroupName(String groupName);
	
}
