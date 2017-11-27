/**
 * 
 */
package com.sdt.sort;

import sun.tools.jar.resources.jar;

/**
 * @author liuqiang
 * 快速排序
 * 挖坑+分治
 */
public class QuickSort {
	 public static int partition(int[] a, int lo, int hi){//返回调整后基数的位置
		int i = lo, j = hi;
		int x = a[lo];//a[i]是第一坑
		while(i < j){
			//从右向左找小于x的数来填a[i]
			while(i < j && a[j] >= x)
				j--;
			if(i < j){
				a[i] = a[j];//将a[j]填坑到a[i]，i++ a[j]形成新坑
				i++;
			}//从左向右找大于x的数来填a[j]
			while(i < j && a[i] < x)
				i++;
			if(i < j){
				a[j] = a[i];//将a[i]填坑到a[j]，j-- a[i]形成新坑
				j--;
			}
		}
		a[i] = x;//退出时， i等于j，将x填到这里
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
