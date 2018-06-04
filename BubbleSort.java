package com.practice.pyusha.arrays;

import java.util.Scanner;

/*
 * input : unsorted array(String)
 * 
 * output: sorted array
 * 
 * complexity: O(n*n) worst case
 * 			   O(n) best case
 */
public class BubbleSort {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String[] arrString = sc.nextLine().split(" ");
	int size = arrString.length;
	int[] arr = new int[arrString.length];
	for(int i = 0;i<arrString.length;i++){
		arr[i] = Integer.parseInt(arrString[i]);
	}
	int[] result = BubbleSortMethod(arr,size);
	for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] +" ");
	}
}
public static int[] BubbleSortMethod(int[] arr,int size){
	for(int i = 0;i<size-1;i++){
		boolean swapped = false;
		int temp = 0;
		for(int j = 0;j<size-i-1;j++){
		if(arr[j] > arr[j+1]){
			temp = arr[j+1];
			arr[j+1]=arr[j];
			arr[j]=temp;
			swapped = true;
		}
		}
		
		if(!swapped)
			break;
	}
	return arr;
}
}
