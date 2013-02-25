package com.cloudconnected.common.system.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;


@Entity
public class StaticModel extends EntityBase {
	
    @NotNull
    @Size(min = 1, max = 6)
    private String locale;

    @NotNull
    @Size(min = 1, max = 25)
    private String modelGroup;

    @NotNull
    @Size(min = 1, max = 25)
    private String modelItem;

    @NotNull
    @Size(min = 1, max = 100)
    private String modelText;

    @NotNull
    private Integer ordinal;
    


	public String getLocale() {    
        return this.locale;        
    }

	public void setLocale(String locale) {    
        this.locale = locale;        
    }

	public String getModelGroup() {    
        return this.modelGroup;        
    }

	public void setModelGroup(String modelGroup) {    
        this.modelGroup = modelGroup;        
    }

	public String getModelItem() {    
        return this.modelItem;        
    }

	public void setModelItem(String modelItem) {    
        this.modelItem = modelItem;        
    }

	public String getModelText() {    
        return this.modelText;        
    }

	public void setModelText(String modelText) {    
        this.modelText = modelText;        
    }


	/**
	 * @return the ordinal
	 */
	public Integer getOrdinal() {
		return ordinal;
	}

	/**
	 * @param ordinal the ordinal to set
	 */
	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}


}
