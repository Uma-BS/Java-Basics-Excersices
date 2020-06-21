package com.umabs;

public class ReverseArray {

	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{1,3,1,1,1,1},
			{1,1,1,1,1,1},
			{1,2,1,1,1,1},
			{1,1,1,1,4,1},
			{1,6,1,1,1,1},
			{1,1,1,1,1,1}
		};
		
		System.out.println(hourGlassCalculator(arr));
		int[] negate= new int[] {-4,-6,-54,-8,-9};
		System.out.println(	maxValue(negate));
	}
	
	public static int[] reverse(int[] a) {
		int temp;
        int j=a.length;
        for(int i=0; i<a.length/2; i++){
               temp=a[j--];
               a[j]=a[i];
               a[i]=temp; 
            }
    return a;
	}
	
	private static int maxValue(int[] a) {
		int max=a[0];
		for (int i = 0; i < a.length; i++) {
			if(a[i]>max) {
				max=a[i];
			}
		}
		
		return max;
	}
	
	public static int hourGlassCalculator(int[][] a) {
		int[][] hourGlass = {{1,1,1},
							 {0,1,0},
							 {1,1,1}
							 };
		
		int sum=0,m=0;
		int[] max = new int[16];
		for (int i = 0; i <= hourGlass.length; i++) {
			for (int j = 0; j <= hourGlass.length; j++) {
				
				for (int k = i; k < i+hourGlass.length; k++) {
					for (int l = j; l < j+hourGlass.length; l++) {
//						System.out.println(i + " "+ j +" "+ k + " " + l +"\n");
						sum = sum + a[k][l]*hourGlass[k-i][l-j];
					}
				}
				max[m] = sum;
				sum=0;
				m++;
			}
			
		}
		
		return maxValue(max);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
