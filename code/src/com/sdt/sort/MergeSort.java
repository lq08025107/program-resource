package com.sdt.sort;

public class MergeSort {
	
	public static void show(int[] array){
		for(int number : array){
			System.out.print(number + " ");
		}
		System.out.println(" ");
	}
	public static void sort(int[] array) {
		int[] tmp = new int[array.length];//����ǰ�Ƚ���һ����ʱ���飬����ڹ���Ƶ�����ٿռ�
		sort(array, 0, array.length - 1,tmp);
	}
	private static void sort(int[] array, int left, int right, int[] tmp) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(array, left, mid, tmp);//��߹鲢����ʹ��������������
			sort(array, mid + 1, right, tmp);//�ұ߹鲢����ʹ��������������
			merge(array, left, mid, right, tmp);//����������������ϲ�
		}
	}
	//������������ϲ�������ָ�룬�ƶ��Ƚ�
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
