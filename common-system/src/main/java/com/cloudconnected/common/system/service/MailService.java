/**
 * 
 */
package com.cloudconnected.common.system.service;

import com.cloudconnected.common.system.domain.MailMessageDetail;


/**
 * This interface should be implemented by a mailing service.
 * It is used to send out mail messages
 * 
 * @author Derek Reynolds
 * @since 1.0
 */
public interface MailService {

	/**
	 * This method is should be implemented to send out a message
	 * based on the {@link MailMessageDetail}
	 * @param mailMessageDetail
	 */
	public void send(MailMessageDetail mailMessageDetails);
	
}
