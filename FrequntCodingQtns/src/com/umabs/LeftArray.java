package com.umabs;

public class LeftArray {

	public static void main(String[] args) {
		int d=10;
		int[] a= new int[] {41 ,73 ,89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
		int[] result= leftArray(d,a);
        for(int i=0; i<result.length; i++ ){
            System.out.println(result[i]);
        }

	}

	public static int[] leftArray(int d,int[] a){
        int[] firsts = new int[d];
        for(int i=0; i<d; i++){
        	firsts[i]=a[i];
//            System.out.println(firsts[i]+ "\n");
        }
        for(int i=d; i<a.length; i++){
            int j=0;
            a[j++]=a[i];
//            System.out.println(a[i]+ "\n");
        }
        int k=0;
        for(int i=a.length-d; i<a.length ; i++){
            a[i]=firsts[k];
//            System.out.println(a[i] + " " + k);
            k++;
        }
        return a;
    }
}
