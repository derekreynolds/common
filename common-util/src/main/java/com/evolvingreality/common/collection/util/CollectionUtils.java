/**
 * 
 */
package com.evolvingreality.common.collection.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class contains methods to help in dealing with Collections.
 * @author Derek Reynolds
 * @since 1.0
 */
public abstract class CollectionUtils {

	/**
	 * This method allows you to add a value to a list that is contained
	 * in a map. If the key is not already in the map it is create and a
	 * new (@link ArrayList} is started.  
	 * @param mapArrayList
	 * @param key
	 * @param value
	 */
	public static <K, V> void addToMappedArrayList(Map<K, List<V>> mapArrayList, K key, V value) {		
		
		if(!mapArrayList.containsKey(key)) {
			mapArrayList.put(key, new ArrayList<V>());
		}
		
		mapArrayList.get(key).add(value);
		
	}
	
	/**
	 * This method allows you to add a value to a list that is contained
	 * in a map. If the key is not already in the map it is create and a
	 * new (@link LinkedList} is started.  
	 * @param mapLinkedList
	 * @param key
	 * @param value
	 */
	public static <K, V> void addToMappedLinkedList(Map<K, List<V>> mapLinkedList, K key, V value) {		
		
		if(!mapLinkedList.containsKey(key)) {
			mapLinkedList.put(key, new LinkedList<V>());
		}
		
		mapLinkedList.get(key).add(value);
		
	}
	
}
