/**
 * 
 */
package com.sdt.sort;

import sun.tools.jar.resources.jar;

/**
 * @author liuqiang
 * 蹇�熸帓搴�
 * 鎸栧潙+鍒嗘不
 */
public class QuickSort {
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
	public static int[] quickSort(int[] array,int start, int end){
		if(start >= end)
			return array;
		int j = partition(array, start, end);
		quickSort(array, start, j - 1);
		quickSort(array, j + 1, end);
		return array;
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
		int[] array = new int[]{24,2,56,23,6,7,9};
		show(array);
		quickSort(array, 0, array.length - 1);
		show(array);

	}

}
