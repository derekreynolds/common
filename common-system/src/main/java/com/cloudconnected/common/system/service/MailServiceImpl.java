/**
 * 
 */
package com.cloudconnected.common.system.service;

import java.text.MessageFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cloudconnected.common.system.domain.MailMessageDetail;



/**
 * This service provides methods to help send email messages.
 * 
 * @author Derek Reynolds
 * @since 1.0
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JavaMailSenderImpl mailSender;


	@Override
	public void send(MailMessageDetail mailMessageDetails) {
		
		logger.debug("Entering");		
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
				
		MimeMessageHelper helper;
		
		try {
			
			helper = new MimeMessageHelper(mimeMessage, true);				
		
			addFrom(helper, mailMessageDetails);
			
			addToRecipients(helper, mailMessageDetails);
			addCcRecipients(helper, mailMessageDetails);
			addBccRecipients(helper, mailMessageDetails);
			
			addSubject(helper, mailMessageDetails);
			addMessage(helper, mailMessageDetails);
			
			mailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			logger.error("Problem building or sending mail message.", e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param helper
	 * @param mailMessageDetails
	 * @throws MessagingException
	 */
	private void addFrom(MimeMessageHelper helper, MailMessageDetail mailMessageDetails) throws MessagingException {
		
		logger.debug("Entering");
		
		helper.setFrom(mailMessageDetails.getFrom());		
	}
	
	/**
	 * 
	 * @param helper
	 * @param mailMessageDetails
	 * @throws MessagingException
	 */
	private void addToRecipients(MimeMessageHelper helper, MailMessageDetail mailMessageDetails) throws MessagingException {
		
		logger.debug("Entering");
		
		for (String recipient : mailMessageDetails.getTo()) {
			logger.info("Adding to recipient {} ", recipient);
			helper.addTo(recipient);
		}
		
	}	
	
	/**
	 * 
	 * @param helper
	 * @param mailMessageDetails
	 * @throws MessagingException
	 */
	private void addCcRecipients(MimeMessageHelper helper, MailMessageDetail mailMessageDetails) throws MessagingException {
		
		logger.debug("Entering");
		
		for (String recipient : mailMessageDetails.getCarbonCopy()) {
			logger.info("Adding cc recipient {} ", recipient);
			helper.addCc(recipient);
		}
		
	}
	
	/**
	 * 
	 * @param helper
	 * @param mailMessageDetails
	 * @throws MessagingException
	 */
	private void addBccRecipients(MimeMessageHelper helper, MailMessageDetail mailMessageDetails) throws MessagingException {
		
		logger.debug("Entering");
		
		for (String recipient : mailMessageDetails.getBlindCarbonCopy()) {
			logger.info("Adding bcc recipient {} ", recipient);
			helper.addBcc(recipient);
		}
		
	}
	
	/**
	 * 
	 * @param helper
	 * @param mailMessageDetails
	 * @throws MessagingException
	 */
	private void addSubject(MimeMessageHelper helper, MailMessageDetail mailMessageDetails) throws MessagingException {
		
		logger.debug("Entering");
		
		String subject = MessageFormat.format(mailMessageDetails.getMailMessage().getMessageSubject(), mailMessageDetails.getSubjectFormatObject().toArray());
		
		logger.info("Adding subject {} ", subject);
		
		helper.setSubject(subject);		
	}
	
	/**
	 * 
	 * @param helper
	 * @param mailMessageDetails
	 * @throws MessagingException
	 */
	private void addMessage(MimeMessageHelper helper, MailMessageDetail mailMessageDetails) throws MessagingException {
		
		logger.debug("Entering");
		
		String message = MessageFormat.format(mailMessageDetails.getMailMessage().getMessageText(), mailMessageDetails.getMessageFormatObject().toArray());
		
		logger.info("Adding message {} ", message);
		
		helper.setText(message);
	}
	
}
