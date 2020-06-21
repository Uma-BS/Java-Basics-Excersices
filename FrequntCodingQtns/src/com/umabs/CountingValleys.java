package com.umabs;

public class CountingValleys {

	
	public static void main(String[] args) {
		int n = 8;
		String hike = "UDDDUDUU";
		
		System.out.println(countingValleys(n,hike));
	}
	
	public static int countingValleys(int n, String s) {
		
		int level=0;
		int valley=0;
		
		for (int j = 0; j < s.length(); j++) {
			if(s.charAt(j)=='U') {
				level++;
			}else if(s.charAt(j)=='D') {
				if(level==0) {
					valley++;
				}
				level--;
			}
					
		}
		
		return valley;
		
		
	}
}
