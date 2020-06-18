package com.umabs.stringEcercise;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindGene {

	/*
	 * Write the method findStopCodon that has three parameters, a String parameter
	 * named dna, an integer parameter named startIndex that represents where the
	 * first occurrence of ATG occurs in dna, and a String parameter named
	 * stopCodon. This method returns the index of the first occurrence of stopCodon
	 * that appears past startIndex and is a multiple of 3 away from startIndex. If
	 * there is no such stopCodon, this method returns the length of the dna strand.
	 */
	private static int findStopCodon(String dna, int startIndex, String stopCodon) {
		// Find stopCodon starting from (startIndex+3), currentIndex gets the result
		int currentIndex = dna.indexOf(stopCodon, startIndex+3);
		// As long as currentIndex is not equal to -1
		while(currentIndex!=-1) {
			// Check if currentIndex-startIndex is a multiple of 3
			if((currentIndex-startIndex) % 3 == 0)
				// if so, currentIndex is answer, return it
				return currentIndex;
			// if not, update currentIndex, looking for stopcodon, again starting from currentIndex+1
			else 
				currentIndex = dna.indexOf(stopCodon, currentIndex+1);
		}
		// If we exit the loop, we didn't find stopCodon, so return dna length
//		return dna.length();
		// we could also handle the above more efficiently by returning -1
		return -1; // Note to make changes in findGene() method
	}
	
	private static String findGene(String dna, int index) {
		int startIndex = dna.toUpperCase().indexOf("ATG", index);
		if(startIndex==-1)
			return " ";
		int taaIndex = findStopCodon(dna.toUpperCase(), startIndex, "TAA");
		int tagIndex = findStopCodon(dna.toUpperCase(), startIndex, "TAG");
		int tgaIndex = findStopCodon(dna.toUpperCase(), startIndex, "TGA");
		
		int minIndex;
//		int minIndex = Math.min(taaIndex, Math.min(tgaIndex, tagIndex));
//		if(minIndex==dna.length()) {
//			return " ";
//		}
		
		if(taaIndex==-1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
			minIndex = tgaIndex;
		} else {
			minIndex = taaIndex;
		}
		
		if(minIndex==-1 || (tagIndex != -1 && tagIndex<minIndex)) {
			minIndex = tagIndex;
		}
		
		if(minIndex == -1) {
			return " ";
		}
		
		return dna.substring(startIndex, minIndex+3);
	}
	
	/*
	 * Write the void method printAllGenes that has one String parameter dna,
	 * representing a string of DNA. In this method you should repeatedly find genes
	 * and print each one until there are no more genes.
	 */ 
	
	private static void printAllGenes(String dna) {
		System.out.println("Find genes from DNA: " + dna);
		// Set stratIndex to 0
		int startIndex = 0;
		// Repeat the following steps
		while(true) {
			// Find the next gene after startIndex
			String gene = findGene(dna, startIndex);
			// If no gene was found, leave/break the loop
			if(gene.isBlank())
				break;
			// Print that gene out
			System.out.println("-> "+gene);
			// Set startIndex to just past the end of the gene
			startIndex = dna.indexOf(gene, startIndex)+gene.length();
		}
	}
	
	private static float cgRatio(String dna) {
		int gcCount = 0;
		for(int i=0; i<dna.length(); i++) {
			if(dna.charAt(i)=='G' || dna.charAt(i)=='C') {
				gcCount++;
			}
		}
		return (float)gcCount / dna.length();
	}
	public static void main(String[] args) {
//		printAllGenes("CGATGATCGCATGATTCATGCTTAAATAAAGCTCA");
//		printAllGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");
//		printAllGenes("ATGATCATAAGAAGATAATAGCGGGCCATGTAA");
//		printAllGenes("ATGATCGCTTGATGCTTAAGCTATG");
//		printAllGenes("AATGCTAACTAGCTGACTAAT");
//		System.out.println(cgRatio("ATGCCATAG"));
		try {
			BufferedReader br = new BufferedReader(new FileReader("DNA.txt"));
			String dna = br.readLine();
			printAllGenes(dna);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
