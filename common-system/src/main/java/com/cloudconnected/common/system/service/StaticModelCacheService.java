/**
 * 
 */
package com.cloudconnected.common.system.service;

import java.util.Map;

/**
 * @author Derek Reynolds
 * @since 1.0
 */
public interface StaticModelCacheService {

	/**
	 * 
	 * @param locale
	 * @param modelGroup
	 * @return
	 */
	public Map<String, String> getByLocaleAndModelGroup(String locale, String modelGroup);
		
	
}
