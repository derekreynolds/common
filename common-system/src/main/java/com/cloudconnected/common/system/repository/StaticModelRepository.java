/**
 * 
 */
package com.cloudconnected.common.system.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudconnected.common.system.model.StaticModel;


/**
 * @author Derek Reynolds
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface StaticModelRepository extends JpaRepository<StaticModel, Long> {

	public List<StaticModel> findByLocaleAndModelGroup(String locale, String modelGroup, Sort sort);
	
	public StaticModel findByLocaleAndModelGroupAndModelItem(String locale, String modelGroup, String modelItem);
	
}
