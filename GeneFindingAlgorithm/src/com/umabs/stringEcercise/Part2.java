package com.umabs.stringEcercise;

public class Part2 {
	
	/*TASK:
	 * 
	 * 1. The method findSimpleGene has one parameter for the DNA string named dna.
	 * Modify findSimpleGene to add two additional parameters, one named startCodon
	 * for the start codon and one named stopCodon for the stop codon. What
	 * additional changes do you need to make for the program to compile? After
	 * making all changes, run your program to check that you get the same output as
	 * before.
	 * 
	 * 2. Modify the findSimpleGene method to work with DNA strings that are either
	 * all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as
	 * “gatgctataat”. Calling findSimpleGene with “ATGGGTTAAGTC” should return the
	 * answer with uppercase letters, the gene “ATGGGTTAA”, and calling
	 * findSimpleGene with “gatgctataat” should return the answer with lowercase
	 * letters, the gene “atgctataa”. HINT: there are two string methods
	 * toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then
	 * dna.toLowerCase() results in the string “atgtaa”.
	 */

	private String findSimpleGene(String dna, String startCodon, String stopCodon) {
		
		int startIndex = dna.toUpperCase().indexOf(startCodon);
		if (startIndex == -1) {
			return "No strat codon found";
		}
		int endIndex = dna.toUpperCase().indexOf(stopCodon, startIndex + 3);
		if (endIndex == -1) {
			return "No end codon found";
		}
		String gene = dna.substring(startIndex, endIndex+3);
		if(gene.length()%3==0) {
			return gene;
		}else {
			return "No gene found";
		}

	}
	
	private void testSampleGene() {
		String startCodon = "ATG";
		String stopCodon = "TAA";
		
		String dna1 = "tcaatgttcctggcctaaatcgat";
		System.out.println("DNA string: " + dna1 + " => " + findSimpleGene(dna1, startCodon, stopCodon));
		
		String dna = "TCAATGTTCCTGGCCTAAATCGAT";
		System.out.println("DNA string: " + dna + " => " + findSimpleGene(dna, startCodon, stopCodon));
		
		String dna2 = "TAGCTATGTCCTGAGGCC";
		System.out.println("DNA string: " + dna2 + " => " + findSimpleGene(dna2, startCodon, stopCodon));
		
		String dna3 = "GCCATCGATCTAATCG";
		System.out.println("DNA string: " + dna3 + " => " + findSimpleGene(dna3, startCodon, stopCodon));
		
		String dna4 = "TCAATGTTCCTGGCTAAATCGAT";
		System.out.println("DNA string: " + dna4 + " => " + findSimpleGene(dna4, startCodon, stopCodon));
	}

	public static void main(String[] args) {
		Part2 p = new Part2();
		p.testSampleGene();
	}
}
