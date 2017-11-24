package com.sdt.sort;


public class HeapSort1 {

	public static void main(String[] args) {
		int[] a = {73,98,27,36,77,22,6,32,83,69};
		show(a);
		a = heapSort(a);
		show(a);

	}
	public static int[] heapSort(int[] a){
		int N = a.length - 1;
		for(int k = N/2; k >= 0; k--){
			sink(a, k, N);
			show(a);
		}
		while(N > 0){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
		return a;
	}
	
	private static void exch(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void sink(int[] a, int k, int N){
		while(2 * k < N){
			int j = 2 * k;
			if(j < N && a[j] < a[j + 1]) j++;
			if(a[k] > a[j]) break;
			exch(a, k, j);
			k = j;
		}
	}
	
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}

}
