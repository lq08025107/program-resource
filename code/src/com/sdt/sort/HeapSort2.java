package com.sdt.sort;

public class HeapSort2 {
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
	
	public static void heapSort(int[] list){
		for(int i = list.length / 2; i >= 0; i--){
			heapAdjust(list, i, list.length);
		}
		for(int i = list.length - 1; i > 0; i--){
			int temp = list[i];
			list[i] = list[0];
			list[0] = temp;
			
			heapAdjust(list, 0, i);
		}
	}
	
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {73,98,27,36,77,22,6,32,83,69};
		show(a);
		heapSort(a);
		show(a);

	}

}
