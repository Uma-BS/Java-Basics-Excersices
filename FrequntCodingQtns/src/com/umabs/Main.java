package com.umabs;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] myArray = getIntegers(6);
		
		printArray(myArray);
//		sortArray(myArray);
//		printArray(myArray);
		reverse(myArray);
	}
	
	public static int[] getIntegers(int count) {

		int[] numbers = new int[count];
		System.out.println("Enter " + count + " numbers to sort: \r");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		return numbers;
	}
	
	public static void printArray(int[] array) {
		System.out.println("The array elements are:\n");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i]>array[j]) {
					int temp;
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
					
				}
			}
		}
		
		return array;
	}
	
	private static void reverse(int[] array) {
		int[] temp = new int[array.length];
		int k=temp.length-1;
		for (int i = 0; i < array.length; i++) {
				temp[k--]=array[i];
			}
			
		System.out.println("The reversed array is: "+ Arrays.toString(temp));
	}
}
