/**
 * 
 */
package com.cloudconnected.common.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.system.model.MailMessage;



/**
 * @author Derek Reynolds
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface MailMessageRepository extends JpaRepository<MailMessage, Long> {

	public MailMessage findByLocaleAndMessageCode(String locale, String messageCode);
	
}
