package com.cloudconnected.common.web.controller;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author Derek Reynolds
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/signIn")
public class SignInController extends AbstractController implements InitializingBean {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String signIn(Model model) {
		
		logger.debug("Entering");
		
		return "signIn";
	}
	
	/**
	 * Add the application constants the application context.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		
		logger.debug("Entering");
		
	}

	
}
