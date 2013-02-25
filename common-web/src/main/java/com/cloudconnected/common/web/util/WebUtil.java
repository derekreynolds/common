/**
 * 
 */
package com.cloudconnected.common.web.util;

import org.apache.commons.lang.WordUtils;

/**
 * This class contains utility methods used by the web components.
 * @author Derek Reynolds
 * @since 1.0
 */
public abstract class WebUtil {

	/**
	 * This method take an object and converts it's name to a
	 * string to resource URI action format e.g. ObjectName will
	 * become object/name.
	 * @param entity
	 * @return a String representing a resource URI
	 */
	public static String entityToResourceUri(Object entity) {
			
		String simpleName = entity.getClass().getSimpleName();
		
		return simpleName.replaceAll("\\B([A-Z])", "/$1").toLowerCase();		
		
	}
	
	/**
	 * This method returns the simple class name for an object.
	 * @param entity
	 * @return the class name.
	 */
	public static String entityClassName(Object entity) {
		return entity.getClass().getSimpleName();
	}
	
	/**
	 * This method returns the default variable name for an
	 * object e.g. ObjectName becomes objectName.
	 * @param entity
	 * @return
	 */
	public static String entityDefaultVariableName(Object entity) {
		return WordUtils.uncapitalize(WebUtil.entityClassName(entity));
	}
	
}
