/**
 * 
 */
package com.cloudconnected.common.system.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;


/**
 * This entity represent a SystemException. It is
 * written to when and exception occurs.
 * @author Derek Reynolds
 * @since 1.0
 */
@Entity
public class SystemException extends EntityBase {
	
	
    @NotNull
    @Size(min = 1, max = 1000)
	private String message;

    @NotNull
    @Size(min = 1, max = 25000)
    private String printStack;

    
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPrintStack() {
		return printStack;
	}

	public void setPrintStack(String printStack) {
		this.printStack = printStack;
	}	
	
}
