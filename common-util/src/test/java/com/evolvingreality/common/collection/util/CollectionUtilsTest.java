package com.evolvingreality.common.collection.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class CollectionUtilsTest {

	@Test
	public void testNewAddToMappedArrayList() {
		
		String key = "arrayList";
		
		Map<String, List<String>> mapArrayList = new HashMap<>();
		
		CollectionUtils.addToMappedArrayList(mapArrayList, key, "first");
		
		assertTrue(!mapArrayList.isEmpty());
		assertTrue(!mapArrayList.values().isEmpty());
	}
	
	@Test
	public void testExistingAddToMappedArrayList() {
		
		String key = "arrayList";
		
		Map<String, List<String>> mapArrayList = new HashMap<>();
		
		CollectionUtils.addToMappedArrayList(mapArrayList, key, "first");
		
		CollectionUtils.addToMappedArrayList(mapArrayList, key, "second");
				
		assertTrue(mapArrayList.size() == 1);
		assertTrue(mapArrayList.get(key).size() == 2);
	}

	@Test
	public void testAddToMappedLinkedList() {
		
		String key = "linkedList";
			
		Map<String, List<String>> mapArrayList = new HashMap<>();
		
		CollectionUtils.addToMappedLinkedList(mapArrayList, key, "first");
		
		assertTrue(!mapArrayList.isEmpty());
		assertTrue(!mapArrayList.values().isEmpty());
	}
	
	@Test
	public void testExistingAddToMappedLinkedList() {
		
		String key = "linkedList";
		
		Map<String, List<String>> mapArrayList = new HashMap<>();
		
		CollectionUtils.addToMappedLinkedList(mapArrayList, key, "first");
		
		CollectionUtils.addToMappedLinkedList(mapArrayList, key, "second");
				
		assertTrue(mapArrayList.size() == 1);
		assertTrue(mapArrayList.get(key).size() == 2);
	}

}
