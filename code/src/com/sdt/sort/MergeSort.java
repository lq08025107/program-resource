package com.sdt.sort;

import com.sun.scenario.effect.Merge;

public class MergeSort {
	
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}
	public static void sort(int[] array) {
		int[] tmp = new int[array.length];
		
	}
	private static void sort(int[] array, int left, int right, int[] tmp) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(array, left, mid, tmp);
			sort(array, mid + 1, right, tmp);
			merge(array, left, mid, right, tmp);
		}
	}
	private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
		int i = left;
		int j = mid + 1;
		
	}
	public static void main(String[] args) {
		int[] array = new int[]{24,2,56,23,6,7,9};
		show(array);
		sort(array, 0, array.length - 1);
		show(array);
	}

}
