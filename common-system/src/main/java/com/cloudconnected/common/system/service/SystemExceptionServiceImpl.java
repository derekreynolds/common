/**
 * 
 */
package com.cloudconnected.common.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudconnected.common.system.model.SystemException;
import com.cloudconnected.common.system.repository.SystemExceptionRepository;


/**
 * @author Derek Reynolds
 * @since 1.0
 *
 */
@Service("systemExceptionService")
public class SystemExceptionServiceImpl implements SystemExceptionService {

	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SystemExceptionRepository systemExceptionRepository;
	
	@Override
	public void save(SystemException systemException) {
		
		logger.debug("Entering");
		
		systemExceptionRepository.save(systemException);
		
	}
	

	
}
