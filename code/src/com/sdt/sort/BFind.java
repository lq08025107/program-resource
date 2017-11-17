package com.sdt.sort;
/**
 * 
 */

/**
 * @author liuqiang
 *
 */
public class BFind {
	public static boolean find(int[] array, int target){
		int start = 0;
		int end = array.length-1;
		while(start <= end){
			int middle = (start + end)/2;
			if(target == array[middle]){
				return true;
			}
			else if(target < array[middle]){
				end = middle - 1;
			}
			else {
				start = middle + 1;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		int target = 9;
		array = new BubbleSort().sort(array);
		boolean flag = find(array, target);
		System.out.println(flag);

	}

}
