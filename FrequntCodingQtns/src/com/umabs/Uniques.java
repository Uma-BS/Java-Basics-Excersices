package com.umabs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
Function Description
Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
sockMerchant has the following parameter(s):
n: the number of socks in the pile
ar: the colors of each sock
Input Format
The first line contains an integer , the number of socks represented in . 
The second line contains  space-separated integers describing the colors  of the socks in the pile.
 */

public class Uniques {

	
	static Integer sockMerchant(int n, int[] ar) {
		List<Integer> match = new ArrayList<>();
       
        Set<Integer> uniques = new HashSet<>();
        for(int i=0; i<ar.length; i++){
            uniques.add(ar[i]);
        }
        System.out.println(uniques);
        
//       Converting Set to an array list of primitive int elements in that array
        int[] unique = uniques.stream().mapToInt(Integer::intValue).toArray();
        
        for(int i=0; i<unique.length; i++) {
        	int temp=0;
            for(int j=0; j<ar.length; j++){
                if(unique[i]==ar[j]){
                    System.out.println(ar[i] + " " + ar[j]);
                	temp++;
                }
            }
            match.add(temp);
        }
        System.out.println(match);
        
        int pairs=0;
        for(int i=0; i<match.size(); i++){
          
                pairs += match.get(i)/2;
            
        }
    return pairs;
    }


	public static void main(String[] args) {
		int[] ar = new int[] {3,0,5,3,0,0,5};
		int n=7;
		System.out.println(sockMerchant(n, ar));
	}
}
