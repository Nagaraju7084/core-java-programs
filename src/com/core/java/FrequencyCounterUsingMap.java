package com.core.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FrequencyCounterUsingMap {

	public static void main(String[] args) {

		String str = "abbbbcdddefffff";
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			Integer value = map.get(c);
			
			if(value != null) {
				map.put(c, new Integer(value+1));
			}else {
				map.put(c, 1);
			}
		}
		System.out.println("before sorting map values are : ");
		System.out.println(map);
		//we have to use sort() of Collection, for this we have to use list
		//we can't convert map to list directly, so the following steps required
		Set<Entry<Character, Integer>> set = map.entrySet();
		
		List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(set);
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> obj1, Entry<Character, Integer> obj2) {
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		
		System.out.println("after sorting list values are : ");
		System.out.println(list);
		System.out.println();
		for(Entry<Character, Integer> entry : list) {
			System.out.println(entry);
		}
	}

}
