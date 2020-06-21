package com.umabs;

public class RepeatedString {

	public static void main(String[] args) {
		long n=54938;
		String s = "a";
		System.out.println(repeatedString(s, n));
	}

	static long repeatedString(String s, long n) {
		s.startsWith("a");
        char[] letters = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='a') {
				count++;
			}
		}
        
        int rem = (int)n%s.length();
        int quotient = (int)n/s.length();
        int extras = 0;
        for(int i=0; i<rem; i++) {
        	if(s.charAt(i)=='a') {
        		extras++;
        	}
        	
        }
        
        return quotient*count + extras;
    }
	
}
