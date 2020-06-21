package com.umabs;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

	public static void main(String[] args) {

		int[][] queryElements = new int[][] {
			{1, 0, 5},
				{1 ,1 ,7},
				{1, 0, 3},
				{2, 1, 0},
				{2, 1, 1}
		};
		int noQuery=5;
		
		List<List<Integer>> queries = new ArrayList<>();
		for(int i = 0; i<noQuery; i++) {
			List<Integer> eachQuery = new ArrayList<>();
			for (int j = 0; j < queryElements.length; j++) {
				for(int k=0; k< queryElements[j].length; k++) {
					int row = queryElements[j][k];
					eachQuery.add(row);
				}
			}
			queries.add(eachQuery);	
		}
		
		System.out.println(queries);
	}

}
