package com.cloudconnected.common.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cloudconnected.common.persistence.model.EntityBase;

@Table(name="STATIC_MODEL")
@Entity
public class StaticModel extends EntityBase {
	
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "locale")
    private String locale;

    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "model_group")
    private String modelGroup;

    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "model_item")
    private String modelItem;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "model_text")
    private String modelText;

    @NotNull
    @Column(name = "ordinal")
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
