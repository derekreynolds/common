/**
 * 
 */
package com.cloudconnected.common.security.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cloudconnected.common.persistence.model.EntityBase;



/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Table(name="SECURITY_GROUP_MEMBER")
@Entity
public class SecurityGroupMember extends EntityBase {

    @NotNull
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;   

    @NotNull
    @ManyToOne(targetEntity = SecurityGroup.class)
    @JoinColumn(name="security_group_id", referencedColumnName="id")
    private SecurityGroup securityGroup;
    
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}   

	
}
