package com.umabs;
import java.util.HashMap;
import java.util.Iterator;

public class DuplicateWords {

	static HashMap<String, Integer> duplicateWords(String str) {
		String[] words = str.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String word : words) {
			if(map.containsKey(word)) { // or if(map.get(word) != null){...}
				map.put(word, map.get(word)+1);
			}else {
				map.put(word, 1);
			}
		}
		return map;
	}
	
	static void displyOnlyDuplictaes(String str) {
		HashMap<String, Integer> map = duplicateWords(str);
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			if(map.get(next)>1) {
				System.out.println("The word \"" + next + "\" appeared " + map.get(next) +" times.");
			}
		}
		
		//Iterator<Integer> iterator2 = map.values().iterator();
	}
}
