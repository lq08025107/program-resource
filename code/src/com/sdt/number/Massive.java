package com.sdt.number;

import com.sdt.sort.BubbleSort;

public class Massive {
	public static double[] bubblesort(double[] array){
		double[] newarray = null;
		for(int i = 0; i <= array.length - 1; i++){
			for(int j = i + 1; j <= array.length - 1; j++){
				if(array[i] > array[j]){
					double tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		newarray = array;
		return newarray;
	}
	public static double[] genRandomNumber(int n){
		double[] num = new double[n];
		for(int i = 0; i < n; i++){
			num[i] = Math.random()*1000000000;
		}
		return num;
	}
	public static void main(String[] args) {

		bubblesort(genRandomNumber(1000000000));
		System.out.println("done");
	}

}
