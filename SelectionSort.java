package com.practice.pyusha.arrays;

import java.util.Scanner;

/*
 * input : unsorted array(String)
 * 
 * output: sorted array
 * 
 * complexity: O(n*n) 
 * 			  
 */
public class SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arrString = sc.nextLine().split(" ");
		int size = arrString.length;
		int[] arr = new int[arrString.length];
		for (int i = 0; i < arrString.length; i++) {
			arr[i] = Integer.parseInt(arrString[i]);
		}
		int[] result = SelectionSortMethod(arr, size);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] SelectionSortMethod(int[] arr, int size) {
		for (int i = 0; i < size - 1; i++) {
			int min_index = i;
			int temp = 0;
			for (int j = i + 1; j < size; j++) {
				if (arr[j] < arr[min_index])
					min_index = j;

				temp = arr[min_index];
				arr[min_index] = arr[i];
				arr[i] = temp;

			}
		}
		return arr;
	}
}
