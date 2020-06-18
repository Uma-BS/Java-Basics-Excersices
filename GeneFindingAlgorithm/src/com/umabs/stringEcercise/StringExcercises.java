package com.umabs.stringEcercise;

public class StringExcercises {

	/*
	 * 1. Write the method named twoOccurrences that has two String parameters named
	 * stringa and stringb. This method returns true if stringa appears at least
	 * twice in stringb, otherwise it returns false.
	 */
	
	private boolean twoOccurrences(String stringA, String stringB) {
		// Search for stringA in stringB starting from index 0
		int firstOccurIndex = stringB.indexOf(stringA);
		if(firstOccurIndex==-1) {
			return false;
		}
		// See if there is second occurrence of stringA in substring of stringB after the first occurrence
		int secondOccurIndex = stringB.indexOf(stringA, firstOccurIndex+stringA.length());
		// If second occurrence found, return true
		if(secondOccurIndex!=-1)
			return true;
		// or else return false
		else
			return false;
	}
	
	/*
	 * Write the method named lastPart that has two String parameters named stringa
	 * and stringb. This method finds the first occurrence of stringa in stringb,
	 * and returns the part of stringb that follows stringa. If stringa does not
	 * occur in stringb, then return stringb.
	 */
	
	private String lastPart(String strA, String strB) {
		int firstIndex = strB.indexOf(strA);
		if(firstIndex==-1) {
			return strB;
		}else {
			return strB.substring(firstIndex+strA.length());
		}
	}
	
	private int countOccurences(String stringA, String stringB) {
		int count = 0;
		int startIndex = 0;
		while(true) {
		int index = stringB.indexOf(stringA, startIndex);
		if(index==-1)
			return count;
		count++;
		startIndex = index + stringA.length();
		}
		
	}
	
	private void testSamples() {
		String str1 = "by";
		String str2 = "A story by Abby Long";
		System.out.println("'"+str1+ "'"+ " appears twice in " + "'" +str2 +"'" +"? : " + twoOccurrences(str1, str2));
		System.out.println("Last part:" + lastPart(str1, str2));
		System.out.println("	'"+str1+"'" + " occurs " + countOccurences(str1, str2) + " times in " + "'"+str2+"'");
		
		str1 = "once";
		str2 = "once upon a time in Mumbai";
		System.out.println("'"+str1 +"'"+ " appears twice in " +"'"+ str2 +"'"+"? : " + twoOccurrences(str1, str2));
		System.out.println("Last part:" + lastPart(str1, str2));
		System.out.println("	'"+str1+"'" + " occurs " + countOccurences(str1, str2) + " times in " + "'"+str2+"'");
		
		str1 = "many";
		str2 = "Too much of infomation";
		System.out.println("'"+str1+"'" + " appears twice in " + "'"+str2+"'" +"? : " + twoOccurrences(str1, str2));
		System.out.println("Last part:" + lastPart(str1, str2));
		System.out.println("	'"+str1+"'" + " occurs " + countOccurences(str1, str2) + " times in " + "'"+str2+"'");
		
		System.out.println("'GAA'" + " occurs " + countOccurences("GAA", "ATGAACGAATTGAATC") + " times in 'ATGAACGAATTGAATC'");
		System.out.println("'AA'" + " occurs " + countOccurences("AA", "ATAAAA") + " times in 'ATAAAA'");
		
	}
	
	public void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
	           String found = input.substring(index+1, index+4);
	           System.out.println(found);
	           index = input.indexOf("abc",index+3);
	       }
	   }
	
	public static void main(String[] args) {
		StringExcercises p = new StringExcercises();
//		p.testSamples();
//		p.findAbc("abcd");
//		p.findAbc("abcdabc");
//		p.findAbc("abcbbbabcdddabc");
//		p.findAbc("yabcyabc");
		
//		p.findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
		p.findAbc("abcabcabcabca");
	}
}
