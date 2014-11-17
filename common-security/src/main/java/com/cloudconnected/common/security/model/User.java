package com.cloudconnected.common.security.model;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cloudconnected.common.persistence.model.EntityBase;
import com.cloudconnected.common.system.domain.YesNoType;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Table(name="USER")
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User extends EntityBase implements UserDetails {


	@NotNull
    @Size(max = 100)
	@Column(name = "email_address")
    private String emailAddress;

    @NotNull
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "password_salt")
    private String passwordSalt;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;
    
    @NotNull
    @Size(max = 30)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_enabled")
    private YesNoType userEnabled;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "locked")
    private YesNoType locked;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "change_password")
    private YesNoType changePassword;    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<SecurityGroupMember> groupMembers = new LinkedList<SecurityGroupMember>();
    
    
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public YesNoType getUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(YesNoType userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authorities = new LinkedList<SimpleGrantedAuthority>(); 
		
		// The user may be a member of more than one group.
		for(SecurityGroupMember member : groupMembers)			
			for(SecurityGroupAuthority authority: member.getSecurityGroup().getAuthorities())		
				authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return this.getEmailAddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return YesNoType.NO.equals(locked);
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {		
		return YesNoType.YES.equals(userEnabled);
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public List<SecurityGroupMember> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(List<SecurityGroupMember> groupMembers) {
		this.groupMembers = groupMembers;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public YesNoType getLocked() {
		return locked;
	}

	public void setLocked(YesNoType locked) {
		this.locked = locked;
	}

	public YesNoType getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(YesNoType changePassword) {
		this.changePassword = changePassword;
	}

}