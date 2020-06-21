package implementations;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BasicCipher {

	public static void main(String[] args) throws IOException {
		int key = 9;

		File fileToEncrypt = new File("secret_msg.txt");
		FileReader fr = new FileReader(fileToEncrypt);

		int info;
		String message = "";
		while ((info = fr.read()) != -1) {
			message += (char) info;
		}

//		System.out.println("Message: " + message);
		String encryptMsg = basicCipher(message.toUpperCase(), key);
//		System.out.println("Encrypted text: " + encryptMsg.toString());
		System.out.println(cipherWithoutChangingCase("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
//		System.out.println(encryptTwoKeys("First Legion", 23, 17));
		System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
		fr.close();

		File encryptedFile = new File("encrypted_msg.txt");
		FileWriter fw = new FileWriter(encryptedFile);
		fw.write(encryptMsg);

		String decryptMsg = basicCipher(encryptMsg, 26 - key);
//		System.out.println("Decrypting to get the text back: "+decryptMsg);

		fw.close();  
	}

	private static String basicCipher(String input, int key) {
		// Create string builder with encrypted message
		StringBuilder encryptedMsg = new StringBuilder(input);
		// Write down the alphabets
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// Write the shifted version of alphabets by key
		String shiftedAlph = alphabets.substring(key) + alphabets.substring(0, key);
		// Loop from 0 to < length of encryptedMsg
		for (int i = 0; i < encryptedMsg.length(); i++) {

			// Find out the index of i'th char in alphabets
			int indexOfCurrChar = alphabets.indexOf(encryptedMsg.charAt(i));
			// If char found in alphabets,
			if (indexOfCurrChar != -1) {
				// Replace the char in encryptedMsg with the char at index in shifted alphabets
				encryptedMsg.setCharAt(i, shiftedAlph.charAt(indexOfCurrChar));
			}
			// If not found, do nothing
		}
		// Answer is the string inside the encryptedMsg
		return encryptedMsg.toString();
	}

	/*
	 * The encrypt method to be able to handle both uppercase and lowercase letters.
	 */
	private static String cipherWithoutChangingCase(String input, int key) {
		StringBuilder encryptedMsg = new StringBuilder(input);
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String shiftedAlph = alphabets.substring(key, 26) + alphabets.substring(0, key) + alphabets.substring(26 + key)
				+ alphabets.substring(26, 26 + key);

		for (int i = 0; i < encryptedMsg.length(); i++) {
			int indexOfCurrChar = alphabets.indexOf(encryptedMsg.charAt(i));
			if (indexOfCurrChar != -1) {
				encryptedMsg.setCharAt(i, shiftedAlph.charAt(indexOfCurrChar));
			}
		}
		return encryptedMsg.toString();
	}

	/**
	 * Method encryptTwoKeys that has three parameters, a String named input, and
	 * two integers named key1 and key2. This method returns a String that has been
	 * encrypted using the following algorithm. Parameter key1 is used to encrypt
	 * every other character with the Caesar Cipher algorithm, starting with the
	 * first character, and key2 is used to encrypt every other character, starting
	 * with the second character.
	 */

	private static String encryptTwoKeys(String input, int key1, int key2) {
		StringBuilder encryptedMsg = new StringBuilder(input);
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String shiftedAlph1 = alphabets.substring(key1,26) + alphabets.substring(0, key1)+ alphabets.substring(26 + key1)
		+ alphabets.substring(26, 26 + key1);
		String shiftedAlph2 = alphabets.substring(key2,26) + alphabets.substring(0, key2) + alphabets.substring(26 + key2)
		+ alphabets.substring(26, 26 + key2);

		for (int i = 0; i < encryptedMsg.length(); i++) {
			int indexOfCurrChar = alphabets.indexOf(encryptedMsg.charAt(i));
			if (indexOfCurrChar != -1) {
				if ((i % 2) == 0) {
					encryptedMsg.setCharAt(i, shiftedAlph1.charAt(indexOfCurrChar));
				} else {
					encryptedMsg.setCharAt(i, shiftedAlph2.charAt(indexOfCurrChar));
				}
			}
		} 
		return encryptedMsg.toString();
	}

}
