/**
 * 
 */
package com.cloudconnected.common.system.domain;

/**
 * An implementor of this interface will
 * implement the build method to construct a MailMessageDetail object.
 * @author Derek Reynolds
 * @version 1.0
 */
public interface MailMessageDetailBuilder {

	/**
	 * This method is invoked to build a mail message based on
	 * the information gathered
	 * @return a MailMessageDetail
	 */
	public MailMessageDetail build();
	
}
