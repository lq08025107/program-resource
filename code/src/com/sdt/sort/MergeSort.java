package com.sdt.sort;

public class MergeSort {
	
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}
	public static void sort(int[] array) {
		int[] tmp = new int[array.length];//排序前先建好一个临时数组，避免第贵重频繁开辟空间
		sort(array, 0, array.length - 1,tmp);
	}
	private static void sort(int[] array, int left, int right, int[] tmp) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(array, left, mid, tmp);//左边归并排序，使得左子序列有序
			sort(array, mid + 1, right, tmp);//右边归并排序，使得又子序列有序
			merge(array, left, mid, right, tmp);//将两个有序子数组合并
		}
	}
	//两个有序数组合并，两个指针，移动比较
	private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			}
			if(arr[i] >= arr[j]) {
				tmp[t++] = arr[j++];
			}
		}
		while(i <= mid) {
			tmp[t++] = arr[i++];
		}
		while(j <= right) {
			tmp[t++] = arr[j++];
		}
		t = 0;
		while(left <= right) {
			arr[left++] = tmp[t++];
		}
		
	}
	public static void main(String[] args) {
		int[] array = new int[]{24,2,56,23,6,7,9};
		show(array);
		sort(array);
		show(array);
	}

}
