/**
 * 
 */
package com.cloudconnected.common.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.system.model.SystemException;



/**
 * @author Derek Reynolds
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface SystemExceptionRepository extends JpaRepository<SystemException, Long> {

	
}
