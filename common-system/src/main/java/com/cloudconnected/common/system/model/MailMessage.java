/**
 * 
 */
package com.cloudconnected.common.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;


/**
 * @author Derek Reynolds
 *
 */
@Table(name="MAIL_MESSAGE")
@Entity
public class MailMessage extends EntityBase {
	
	
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "locale")
	private String locale;
	
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "message_code")
    private String messageCode;

	@NotNull
    @Size(min = 1, max = 100)
	@Column(name = "message_subject")
	private String messageSubject;
	
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "message_text")
	private String messageText;

    
   
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	
	
}
