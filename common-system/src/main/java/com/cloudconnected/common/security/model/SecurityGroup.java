/**
 * 
 */
package com.cloudconnected.common.security.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;



/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Entity
public class SecurityGroup extends EntityBase {

    @NotNull
    @Size(max = 100)
	private String groupName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="securityGroup")
    private List<SecurityGroupAuthority> authorities = new LinkedList<SecurityGroupAuthority>();
    
    
    
	public List<SecurityGroupAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<SecurityGroupAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
