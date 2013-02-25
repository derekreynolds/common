/**
 * 
 */
package com.cloudconnected.common.system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cloudconnected.common.system.model.StaticModel;
import com.cloudconnected.common.system.repository.StaticModelRepository;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Service("staticModelService")
public class StaticModelServiceImpl implements StaticModelService {

	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StaticModelRepository staticModelRepository;
	
	/* (non-Javadoc)
	 * @see com.cloudconnected.onleave.system.service.StaticModelService#getById(java.lang.Long)
	 */
	@Override
	public StaticModel getById(Long id) {
		
		logger.debug("Entering with id {}", id);
		
		return staticModelRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.cloudconnected.onleave.system.service.StaticModelService#get(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<StaticModel> get(Pageable pageable) {
		
		logger.debug("Entering with page {}, size {}", pageable.getPageNumber(), pageable.getPageSize());
		
		return staticModelRepository.findAll(pageable);
	}

	@Override
	public List<StaticModel> getByLocaleAndModelGroup(String locale, String modelGroup) {
		
		logger.debug("Entering with locale {}, modelGroup {}", locale, modelGroup);
		
		return staticModelRepository.findByLocaleAndModelGroup(locale, modelGroup, new Sort(Sort.Direction.ASC, "ordinal"));
	}

	@Override
	public StaticModel getByLocaleAndModelGroupAndModelItem(String locale, String modelGroup,
			String modelItem) {
		
		logger.debug("Entering with locale {}, modelGroup {}, modelItem", new Object [] {locale, modelGroup, modelItem});
		
		return staticModelRepository.findByLocaleAndModelGroupAndModelItem(locale, modelGroup, modelItem);
	}
	
	

}
