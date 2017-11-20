package com.sdt.number;
/*
 * fibnacci数列 1,1,2,3,5
 */

public class Fibnacci {
	public static int Fibnacci0(int number){
		if(number < 0) return -1;
		if(number == 0) return 0;
		if(number == 1 || number == 2) return 1;
		return Fibnacci0(number-1) + Fibnacci0(number-2);
		
	}
	public static int Fibnacci1(int number){
		if(number < 0) return -1;
		if(number == 0) return 0;
		if(number == 1 || number == 2) return 1;
		int a = 1, b = 1, c = 0;
		for(int i = 3; i <= number; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	public static int Fibnacci2(int number){
		if(number < 0) return -1;
		if(number == 0) return 0;
		if(number == 1 || number == 2) return 1;
		int[] array = new int[number + 1];
		array[0] = 0; array[1] = 1; array[2] = 1;
		for(int i = 3; i <= number; i++){
			 array[i] = array[i-1] + array[i-2];
		}
		return array[number];
	}
	public static void main(String[] args) {
		for(int i = 0; i <= 20; i++){
			System.out.print(Fibnacci2(i) + " ");
		}
	}

}
