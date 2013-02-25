/**
 * 
 */
package com.cloudconnected.common.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudconnected.common.system.model.StaticModel;


/**
 * This service provides operation in relation to the {@link StaticModel}.
 * @author Derek Reynolds
 * @since 1.0
 */
public interface StaticModelService {

	public StaticModel getById(Long id);
	
	public Page<StaticModel> get(Pageable pageable);
	
	public List<StaticModel> getByLocaleAndModelGroup(String locale, String modelGroup);
	
	public StaticModel getByLocaleAndModelGroupAndModelItem(String locale, String modelGroup, String modelItem);
	
}
