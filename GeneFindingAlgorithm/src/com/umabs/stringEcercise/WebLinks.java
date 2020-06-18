package com.umabs.stringEcercise;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WebLinks {
	
	/*
	 * Finding Web Links: 
	 * 		Write a program that reads the lines from a HTML file, 
	 * 		webLinks.html, and prints each URL on the page that is a link to youtube.com.
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\UMA RANI\\Desktop\\webLinks.html");
		FileReader fr = new FileReader(file);

		String searchFor = "youtube.com";
		String data = "";
		int i;
		
//		Read till the end of the file and store the data in string format
		while ((i = fr.read()) != -1) {
			data = data + (char) i;
		}

		System.out.println(findYouTubeLinks(data, searchFor));

		fr.close();
	}

	private static List<String> findYouTubeLinks(String data, String searchString) {
		List<String> links = new ArrayList<>(); 
		int startIndex = 0;
		// Find all links as long as there are links to youtube.com in the html file
		while (true) {
		    // Search for 'youtube.com' and mark the index
			int wordIndex = data.toLowerCase().indexOf(searchString, startIndex);
			// If there are no more links to youtube.com break the loop
			if(wordIndex==-1)
				break;
		    // Look for the open quotation mark prior to 'youtube.com' and note starting quatation index
			int startQuote = data.lastIndexOf("\"", wordIndex);
		    // Now search for the end of quotation after the open quotation to note it's index
			int endQuote = data.indexOf("\"", startQuote + 1);
		    // The substring of data in between start and end of quotation mark forms a link to a youtube video
			links.add(data.substring(startQuote+1, endQuote));
			// Update startIndex to the end of quotation mark to search for more links following it.
			startIndex = endQuote+1;
		}
		return links;
	}

}
