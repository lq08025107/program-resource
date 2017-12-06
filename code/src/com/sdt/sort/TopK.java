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
	//堆排序实现topk,首先维护一个k大小的堆，找最小用大顶堆，找最大用小顶堆，开始遍历数组，如果比堆顶小，则替换堆顶元素，然后调整
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
	 public static int partition(int[] a, int lo, int hi){//杩斿洖璋冩暣鍚庡熀鏁扮殑浣嶇疆
		int i = lo, j = hi;
		int x = a[lo];//a[i]鏄涓�鍧�
		while(i < j){
			//浠庡彸鍚戝乏鎵惧皬浜巟鐨勬暟鏉ュ～a[i]
			while(i < j && a[j] >= x)
				j--;
			if(i < j){
				a[i] = a[j];//灏哸[j]濉潙鍒癮[i]锛宨++ a[j]褰㈡垚鏂板潙
				i++;
			}//浠庡乏鍚戝彸鎵惧ぇ浜巟鐨勬暟鏉ュ～a[j]
			while(i < j && a[i] < x)
				i++;
			if(i < j){
				a[j] = a[i];//灏哸[i]濉潙鍒癮[j]锛宩-- a[i]褰㈡垚鏂板潙
				j--;
			}
		}
		a[i] = x;//閫�鍑烘椂锛� i绛変簬j锛屽皢x濉埌杩欓噷
		return i;
	}
	//快排实现topk
	public static int[] getTopK_quick(int[] array, int k){
		int[] result = new int[k];
		if(array != null && array.length > 0) {
			int low = 0;
			int high = array.length - 1;
			int index = partition(array, low, high);
			while(index != k - 1) {
				if(index > k -1) {
					high = index - 1;
					index = partition(array, low, high);
				}
				if(index < k - 1) {
					low = index + 1;
					index = partition(array, low, high);
				}
			}
		}
		for(int i = 0; i < k; i++) {
			result[i] = array[i];
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 9, 3, 10, 10, 5, 7, 6, 20, 8, 50 };
		int[] result = getTopK_heap(array, 4);
		//int[] result = getTopK_quick(array, 4);
		show(result);
	}

}
