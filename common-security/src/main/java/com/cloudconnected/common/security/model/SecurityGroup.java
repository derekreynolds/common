/**
 * 
 */
package com.cloudconnected.common.security.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;



/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Table(name="SECURITY_GROUP")
@Entity
public class SecurityGroup extends EntityBase {

    @NotNull
    @Size(max = 100)
    @Column(name = "group_name")
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
