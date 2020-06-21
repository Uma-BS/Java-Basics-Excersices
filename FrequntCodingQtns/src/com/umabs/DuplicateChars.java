package com.umabs;
import java.util.HashMap;
import java.util.Iterator;

public class DuplicateChars {

	static void duplicateChars(String str) {
		char[] chars = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (char c : chars) {
			if(map.get(c) != null) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		
		Iterator<Character> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			Character next = iterator.next();
			if(map.get(next)>1) {
				System.out.println(next + " occoured " + map.get(next) +" times");
			}
		}
	}
}
