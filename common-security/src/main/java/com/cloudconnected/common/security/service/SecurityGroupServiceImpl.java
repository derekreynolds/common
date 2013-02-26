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

import com.cloudconnected.common.security.model.SecurityGroup;
import com.cloudconnected.common.security.repository.SecurityGroupRepository;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Transactional(readOnly=true)
@Service("securityGroupService")
public class SecurityGroupServiceImpl implements SecurityGroupService {
	
	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SecurityGroupRepository securityGroupRepository;
	
	@Override
	@Transactional(readOnly = false)
	public void save(SecurityGroup securityGroup) {
		
		logger.debug("Entering");
		
		securityGroupRepository.save(securityGroup);
	}

	
	@Override
	@Transactional(readOnly = false)
	public void delete(SecurityGroup securityGroup) {		

		logger.debug("Entering with {}", securityGroup.getId());
		
		securityGroupRepository.delete(securityGroup);
		
	}

	@Override
	public Page<SecurityGroup> getSecurityGroups(Pageable pageable) {
		
		logger.debug("Entering");
		
		return securityGroupRepository.findAll(pageable);

	}


	@Override
	public SecurityGroup getById(Long id) {
		
		logger.debug("Entering with {}", id);
		
		return securityGroupRepository.findOne(id);
	}


	@Override
	public SecurityGroup getByGroupName(String groupName) {
		
		logger.debug("Entering with {}", groupName);
		
		return securityGroupRepository.findByGroupName(groupName);
	}

}
