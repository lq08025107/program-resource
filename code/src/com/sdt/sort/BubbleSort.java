package com.sdt.sort;
/**
 * 
 */

/**
 * @author liuqiang
 *
 */
public class BubbleSort {
	public static int[] sort(int[] array){
		int[] newarray = null;
		for(int i = 0; i <= array.length - 1; i++){
			for(int j = i + 1; j <= array.length - 1; j++){
				if(array[i] > array[j]){
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		newarray = array;
		return newarray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,2,7,1,5,3,2};
		int[] newarray = sort(array);
		for (int i : newarray) {
			System.out.print(i + " ");
		}

	}

}
