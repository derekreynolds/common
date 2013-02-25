/**
 * 
 */
package com.cloudconnected.common.system.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cloudconnected.common.system.model.StaticModel;


/**
 * @author Derek Reynolds
 * @since 1.0
 */
@Service("staticModelCacheService")
public class StaticModelCacheServiceImpl implements StaticModelCacheService {

	/**
	 * Get log object from log factory.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StaticModelService staticModelService;

	@Override
	@Cacheable("staticModel")
	public Map<String, String> getByLocaleAndModelGroup(String locale,
			String modelGroup) {
		
		logger.debug("Entering with locale {}, modelGroup {}", locale, modelGroup);
		
		Map<String, String> keyValues = new LinkedHashMap<String, String>();
		
		List<StaticModel> staticModels = staticModelService.getByLocaleAndModelGroup(locale, modelGroup);
		
		if(staticModels.isEmpty()) {
			staticModels = staticModelService.getByLocaleAndModelGroup("EN", modelGroup);
		}	
			
		for (StaticModel staticModel : staticModels) {
			keyValues.put(staticModel.getModelItem(), staticModel.getModelText());
		}
		
		return keyValues;
	}
	
	
	
}
