package implementations;

public class WordPlay {

	public static void main(String[] args) {
		System.out.println(replaceVowels("Elephane is a Big Animal", '*'));
		System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
	}
	

	/*
	 * return a String that is the string phrase with all the vowels (uppercase
	 * or lowercase) replaced by 'replaceWith' char.
	 */	
	private static String replaceVowels(String phrase, char replaceWith) {
		// Set the jumble word as phrase
		StringBuilder jumbledWord = new StringBuilder(phrase);
		
		// Loop over each char in jumbledword (call it i)
		for (int i = 0; i < jumbledWord.length(); i++) {
			char currChar = jumbledWord.charAt(i);
			// Check if the current char is vowel or not
			boolean isVowel = isVowel(currChar);
			if (isVowel) {
				// If the current char is vowel replace it with *
				jumbledWord.setCharAt(i, replaceWith);
			}
			// Otherwise: Do nothing
		}
		// Return the replaced string
		return jumbledWord.toString();
	}

	private static boolean isVowel(char ch) {
		String vowel = "aeiou";
		
		if(vowel.indexOf(Character.toLowerCase(ch)) != -1)
			return true;
		
		return false;
	}
	
	/**
	 * Method emphasize with two parameters, a String named phrase and a character
	 * named ch, returns a String that is the string phrase but
	 * with the Char ch (upper- or lowercase) replaced by; 
	 * 		‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number
	 * 			location but an even index, it is at index 0), or
	 * 
	 * 		‘+’ if it is in an even number location in the string (e.g. the second
	 * 			character has an even number location but an odd index, it is at index 1).
	 * 
	 * @param phrase
	 * @param ch
	 * @return
	 */
	private static String emphasize(String phrase, char ch) {
		//Set emphasizedPhrase with given phrase 
		StringBuilder emphasizedPhrase = new StringBuilder(phrase);
		
		// Loop over the emphasizedPhrase for each char in it
		for(int i=0; i<emphasizedPhrase.length(); i++) {
			char currChar = emphasizedPhrase.charAt(i);
			// If the current char is ch
			if(Character.toLowerCase(currChar) == ch) {
			// Also, if the location is odd(or, has even index)
				if((i % 2) == 0)
					// Replace the current char with *
					emphasizedPhrase.setCharAt(i, '*');
			// or, if the location is even(or, has odd index)
				else
					// Replace it with +
					emphasizedPhrase.setCharAt(i, '+');
			}
		}
		// The answer is in emphasizedPhrase. Return it
		return emphasizedPhrase.toString();
	}
}
