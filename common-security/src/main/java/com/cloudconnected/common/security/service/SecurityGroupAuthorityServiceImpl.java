/**
 * 
 */
package com.cloudconnected.common.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.security.model.SecurityGroupAuthority;
import com.cloudconnected.common.security.repository.SecurityGroupAuthorityRepository;

/**
 * @author Derek Reynolds
 *
 */
@Transactional(readOnly=true)
@Service("securityGroupAuthorityService")
public class SecurityGroupAuthorityServiceImpl implements
		SecurityGroupAuthorityService {

	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SecurityGroupAuthorityRepository securityGroupAuthorityRepository;
	
	/* (non-Javadoc)
	 * @see com.cloudconnected.onleave.security.service.SecurityGroupAuthorityService#save(com.cloudconnected.onleave.security.model.SecurityGroupAuthority)
	 */
	@Override
	public void save(SecurityGroupAuthority securityGroupAuthority) {
		
		logger.debug("Entering");
		
		securityGroupAuthorityRepository.save(securityGroupAuthority);

	}

	@Override
	public void delete(SecurityGroupAuthority securityGroupAuthority) {
		
		logger.debug("Entering with {}", securityGroupAuthority.getId());
	
		securityGroupAuthorityRepository.delete(securityGroupAuthority);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.cloudconnected.onleave.security.service.SecurityGroupAuthorityService#getSecurityGroupAuthorities(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<SecurityGroupAuthority> getSecurityGroupAuthorities(
			Pageable pageable) {
		
		logger.debug("Entering");
		
		return securityGroupAuthorityRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see com.cloudconnected.onleave.security.service.SecurityGroupAuthorityService#getSecurityGroupAuthority(java.lang.Long)
	 */
	@Override
	public SecurityGroupAuthority getSecurityGroupAuthority(Long id) {
		
		logger.debug("Entering with {}", id);
		
		return securityGroupAuthorityRepository.findOne(id);
	}

	@Override
	public Page<SecurityGroupAuthority> getSecurityGroupAuthorityForSecurityGroup(
			Long securityGroupId, Pageable pageable) {
		
		logger.debug("Entering with {}", securityGroupId);		
		
		return securityGroupAuthorityRepository.findBySecurityGroup_Id(securityGroupId, pageable);
	}

}
