package com.sdt.sort;

public class TopK {
	public static void heapAdjust(int[] array, int parent, int length){
		int temp = array[parent];
		int child = 2 * parent + 1;
		
		while(child < length){
			if(child + 1 < length && array[child] < array[child + 1]){
				child ++;
			}
			if(temp >= array[child])
				break;
			
			array[parent] = array[child];
			parent = child;
			child = 2 * child + 1;
		}
		array[parent] = temp;
	}
	public static void buildHeap(int[] array) {
		int length = array.length;
		for(int i = length / 2 - 1; i >= 0; i--) {
			heapAdjust(array, i, length);
		}
	}
	public static void setTop(int[] array, int top) {
		array[0] = top;
		heapAdjust(array, 0, array.length);
	}

	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}
	//堆排序实现topk
	public static int[] getTopK_heap(int[] array, int k){
		int[] top = new int[k];
		for(int i = 0; i< k; i++) {
			top[i] = array[i];
		}
		buildHeap(top);
		for(int j = k; j < array.length; j++) {
			int tmp = top[0];
			if(array[j] < tmp) {
				setTop(top, array[j]);
			}
		}
		return top;
	}
	//快排实现topk
	public static void getTopK_quick(int[] array, int count){}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 9, 3, 10, 10, 5, 7, 6, 20, 8, 0 };
		int[] result = getTopK_heap(array, 4);
		//getTopK_quick(array, 4);
		show(result);
	}

}
