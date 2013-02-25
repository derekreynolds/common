/**
 * 
 */
package com.cloudconnected.common.system.domain;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloudconnected.common.system.model.MailMessage;
import com.cloudconnected.common.system.repository.MailMessageRepository;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
public abstract class MailMessageDetailBuilderSupport implements
		MailMessageDetailBuilder {	
	
	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired	
	private MailMessageRepository mailMessageRepository;
	
	/* (non-Javadoc)
	 * @see com.cloudconnected.onleave.system.domain.MailMessageDetailBuilder#build()
	 */
	@Override
	public abstract MailMessageDetail build();

	
	protected MailMessage getMailMessage(String locale, String messageCode) {	
		
		logger.debug("Entering with {}, {}", locale, messageCode);
				
		MailMessage mailMessage = mailMessageRepository.findByLocaleAndMessageCode(locale, messageCode);
		
		if(mailMessage == null) {
			mailMessage = mailMessageRepository.findByLocaleAndMessageCode(Locale.ENGLISH.getLanguage(), messageCode);
		}
		
		if(mailMessage == null) {
			throw new IllegalArgumentException("No Mail Message for Locale and MessageCode");
		}
		
		return mailMessage;
	}

}
