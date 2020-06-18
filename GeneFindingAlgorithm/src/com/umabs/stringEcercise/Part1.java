package com.umabs.stringEcercise;

public class Part1 {
	/*
		A DNA string is made up of nucleotides: A, T, G, C. Combination containing 3 of these forms a Codon. Ex: ATC, TGC etc,. 
		A gene is a combination of these codons, starting with ATG codon and ends with TAA.
		
		This class is used to find simple genes from a DNA string of any length. 
	*/
	
	/*TASK:
	 * 
	 *-> Finds the index position of the start codon “ATG”. If there is no “ATG”,
	 *   return the empty string. 
	 *-> Finds the index position of the first stop codon
	 *   “TAA” appearing after the “ATG” that was found. If there is no such “TAA”,
	 *   return the empty string. 
	 *-> If the length of the substring between the “ATG” and
	 *   “TAA” is a multiple of 3, then return the substring that starts with that
	 *   “ATG” and ends with that “TAA”.
	 */
	
	/*
	 * Method to find the gene from the DNA strand. Takes DNA strand in String as
	 * parameter and returns String, either the gene that was found(if one found) or
	 * a msg
	 */
	private String findSimpleGene(String dna) {
//		Search for ATG codon and set the index as 'startIndex'
		int startIndex = dna.indexOf("ATG");
//		Return empty string if no start codon was found
		if (startIndex == -1) {
			return " ";
		}
//		Search for TAA codon starting from the index 'stratIndex+3' (3 is the length of the start codon) and set the index as 'endIndex'
		int endIndex = dna.indexOf("TAA", startIndex + 3);
//		Return empty string if no end codon was found 
		if (endIndex == -1) {
			return " ";
		}
//		The string in between stratIndex and endIndex is a gene. extract that gene
		String gene = dna.substring(startIndex, endIndex+3);
//		A valid gene must contain codons which are formed of 3 nucleotides. Thus,the string length between startIndex and endIndex 
//		should be multiple of 3. If not it is not a valid gene
		if(gene.length()%3==0) {
			return gene;
		}else {
			return " ";
		}

	}
	
	private void testSampleGene() {
		String dna1 = "TCAATGTTCCTGGCCTAAATCGAT";
		System.out.println("DNA string: " + dna1 + " => " + findSimpleGene(dna1));
		
		String dna2 = "TAGCTATGTCCTGAGGCC";
		System.out.println("DNA string: " + dna1 + " => " + findSimpleGene(dna2));
		
		String dna3 = "GCCATCGATCTAATCG";
		System.out.println("DNA string: " + dna1 + " => " + findSimpleGene(dna3));
		
		String dna4 = "TCAATGTTCCTGGCTAAATCGAT";
		System.out.println("DNA string: " + dna1 + " => " + findSimpleGene(dna4));
	}

	public static void main(String[] args) {
		Part1 p = new Part1();
		p.testSampleGene();
	}

}
