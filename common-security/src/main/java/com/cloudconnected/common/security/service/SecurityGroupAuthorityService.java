/**
 * 
 */
package com.cloudconnected.common.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudconnected.common.security.model.SecurityGroupAuthority;



/**
 * @author Derek Reynolds
 * @since 1.0
 */
public interface SecurityGroupAuthorityService {

	public void save(SecurityGroupAuthority securityGroupAuthority);
	
	public void delete(SecurityGroupAuthority securityGroupAuthority);
	
	public Page<SecurityGroupAuthority> getSecurityGroupAuthorities(Pageable pageable);
	
	public SecurityGroupAuthority getSecurityGroupAuthority(Long id);
	
	public Page<SecurityGroupAuthority> getSecurityGroupAuthorityForSecurityGroup(Long securityGroupId, Pageable pageable);
}
