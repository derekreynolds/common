package com.cloudconnected.common.system.service;

import com.cloudconnected.common.system.model.SystemException;



/**
 * Interface to expose operations available for System 
 * Exception related services.
 * @author Derek Reynolds
 * since 1.0
 */
public interface SystemExceptionService {

	/**
	 * Persists the @link SystemException} to the datasource.
	 * @param systemException
	 */
	public void save(SystemException systemException);
	
}
