package com.cloudconnected.common.persistence.model;


import java.lang.reflect.Method;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ReflectionUtils;


/**
 * This is the base class for all the persisted entities
 * in the system.
 * @author Derek Reynolds
 * @since 1.0
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class EntityBase implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Calendar createdTimestamp; 
    
    @Size(max = 100)
    private String updatedBy;
  
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Calendar updatedTimestamp; 

	
	@PrePersist
	@PreUpdate
	public void updateUserNameAndTimestamp(){
		
		if(getCreatedTimestamp() == null) {
			setCreatedTimestamp(Calendar.getInstance());
		}	
			
		if(SecurityContextHolder.getContext().getAuthentication() != null) {		
			setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		}
		
		setUpdatedTimestamp(Calendar.getInstance());	
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Method thisMethod  = ReflectionUtils.findMethod(this.getClass(), "getId");		
		Method otherMethod  = ReflectionUtils.findMethod(obj.getClass(), "getId");
		
		if((thisMethod == null) || (otherMethod == null))
			throw new IllegalStateException("No getId method on entity.");
		
		Long thisId = (Long) ReflectionUtils.invokeMethod(thisMethod, this);
		Long otherId = (Long) ReflectionUtils.invokeMethod(otherMethod, this);
		
		if((thisId == null) || (otherId == null)) 
			return false;
		
		if(thisId != otherId)
			return false;
		
		return true;
		
	}
	
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public java.util.Calendar getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(java.util.Calendar createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}	

	public String getUpdatedBy() {    
        return this.updatedBy;        
    }

	public void setUpdatedBy(String updatedBy) {    
        this.updatedBy = updatedBy;        
    }

	public Calendar getUpdatedTimestamp() {    
        return this.updatedTimestamp;        
    }

	public void setUpdatedTimestamp(Calendar updatedTimestamp) {    
        this.updatedTimestamp = updatedTimestamp;        
    }

}