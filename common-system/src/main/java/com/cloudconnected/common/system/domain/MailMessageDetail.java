/**
 * 
 */
package com.cloudconnected.common.system.domain;

import java.util.ArrayList;
import java.util.List;

import com.cloudconnected.common.system.model.MailMessage;


/**
 * @author Derek Reynolds
 *
 */
public class MailMessageDetail {
	
	private MailMessage mailMessage;
	
	private String from;
	
	private List<String> to = new ArrayList<String>();
	
	private List<String> carbonCopy = new ArrayList<String>();
	
	private List<String> blindCarbonCopy = new ArrayList<String>();
	
	private List<Object> subjectFormatObject =  new ArrayList<Object>();
	
	private List<Object> messageFormatObject =  new ArrayList<Object>();
	
		
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	
	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}
	
	public void addTo(String recipient) {
		this.to.add(recipient);
	}

	public List<String> getCarbonCopy() {
		return carbonCopy;
	}

	public void setCarbonCopy(List<String> carbonCopy) {
		this.carbonCopy = carbonCopy;
	}
	
	public void addCc(String recipient) {
		this.carbonCopy.add(recipient);
	}

	public List<String> getBlindCarbonCopy() {
		return blindCarbonCopy;
	}

	public void setBlindCarbonCopy(List<String> blindCarbonCopy) {
		this.blindCarbonCopy = blindCarbonCopy;
	}
	
	public void addBcc(String recipient) {
		this.blindCarbonCopy.add(recipient);
	}

	public List<Object> getSubjectFormatObject() {
		return subjectFormatObject;
	}

	public void setSubjectFormatObject(List<Object> subjectFormatObject) {
		this.subjectFormatObject = subjectFormatObject;
	}

	public void addSubjectFormatObject(Object object) {
		this.subjectFormatObject.add(object);
	}
	
	public List<Object> getMessageFormatObject() {
		return messageFormatObject;
	}

	public void setMessageFormatObject(List<Object> messageFormatObject) {
		this.messageFormatObject = messageFormatObject;
	}
	
	public void addMessageFormatObject(Object object) {
		this.messageFormatObject.add(object);
	}

	public MailMessage getMailMessage() {
		return mailMessage;
	}

	public void setMailMessage(MailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}
}
