package com.cloudconnected.common.web.controller;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ServletContextAware;



/**
 * This is an abstract controller that can be implemented
 * by the controllers in the application.
 * @author Derek Reynolds
 * @version 1.0
 */
public abstract class AbstractController implements ServletContextAware {

	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
		
			
	@Autowired
	protected ApplicationContext applicationContext;
	
	private ServletContext servletContext;	
		
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;		
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	
	
}
