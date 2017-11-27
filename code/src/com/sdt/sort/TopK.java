package com.sdt.sort;

public class TopK {
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}
	//堆排序实现topk
	public static void getTopK_heap(int[] array, int count){}
	//快排实现topk
	public static void getTopK_quick(int[] array, int count){}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 9, 3, 1, 10, 5, 7, 6, 2, 8, 0 };
		getTopK_heap(array, 4);
		getTopK_quick(array, 4);
		show(array);
	}

}
