/**
 * 
 */
package com.cloudconnected.common.security.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Entity
public class SecurityGroupAuthority extends EntityBase {
	
	
    @NotNull
    @Size(max = 100)
	private String authority;

    @NotNull
    @ManyToOne(targetEntity = SecurityGroup.class)
    @JoinColumn(name="securityGroup", referencedColumnName="id")
    private SecurityGroup securityGroup;   
    
    
	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
