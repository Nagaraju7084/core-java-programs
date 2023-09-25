package com.core.collection.framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMEAndSolution {
	
	public static void main(String[] args) {
		
		//concurrent hashmap
		
		Map<String, String> conHashMap = new ConcurrentHashMap<>();
		conHashMap.put("1", "1");
		conHashMap.put("2", "2");
		conHashMap.put("3", "3");
		conHashMap.put("4", "4");
		
		System.out.println("concurrent hash map before iterating:\t"+conHashMap);
		for (Map.Entry<String,String> entry : conHashMap.entrySet()) {
			String key = entry.getKey();
			if(key.equals("3")){
				conHashMap.put(key+"new3", "new3");
			}
		}
		System.out.println("concurrent hash map after iterating:\t"+conHashMap);
		
		//hashmap
		
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("1", "1");
		hashMap.put("2", "2");
		hashMap.put("3", "3");
		hashMap.put("4", "4");
		
		System.out.println("hashmap before iterating:\t"+hashMap);
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			if(key.equals("3"));
			hashMap.put(key+"new3", "new3");
		}
		System.out.println("hashmap after iterating:\t"+hashMap);
	}
}
