package com.umabs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class JumpClouds {

	public static void main(String[] args) {
	
		int[] clouds= new int[] {0,0,0,1,0,0};
//		jumpingOnClouds(clouds);
     	System.out.println(jumpingOnClouds(clouds));
	}

	private static int jumpingOnClouds(int[] clouds) {
		List<Integer> cloudList = new LinkedList<Integer>();
		for (int i = 0; i < clouds.length; i++) {
			cloudList.add(clouds[i]);
		}
		
		
		int jump=0;
		ListIterator<Integer> loop = cloudList.listIterator(1);
		if(loop.hasNext()) {
			if(loop.next()==1) {
//				loop.next();
			}else if(loop.next()==0) {
				if(loop.next()==0) {
					jump++;
				}
			}
		}
		return jump;
	}
		
		
		
//		int jump=0;
//		int flag=0;
//		for (int i = 1; i < clouds.length; i++) {
//			if(clouds[i]==1) {
//				flag=0;
//			}else if(clouds[i]==0) {
//				if(flag==0 || i==clouds.length-1) {
//					jump++;
//					flag=1;
//				}
//			}
//		}
//		return jump;
	
}
