package com.umabs;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplictaesFromString {

	public static void removeDuplictaes(String str) {

		String[] words = str.split(" ");
		Set<String> set = new LinkedHashSet<>();
		
		for (String word : words) {
			set.add(word);
		}
		Iterator<String> iterator = set.iterator();
		String result = "";
		while(iterator.hasNext()) {
			result = result + iterator.next() + " ";
		}
		System.out.println(result);
	}
}
