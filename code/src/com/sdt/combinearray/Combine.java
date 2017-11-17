package com.sdt.combinearray;

public class Combine {
	public static int[] combine(int[] a, int[] b){
		int lena = a.length;
		int lenb = b.length;
		int i = 0, j = 0, k = 0;
		int[] c = new int[lena + lenb];
		while(i < lena && j < lenb){
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			}
			else{
				c[k++] = b[j++];
			}
		}
		while(i < lena){c[k++] = a[i++];}
		while(j < lenb){c[k++] = b[j++];}
		return c;
	}
	public static void main(String[] args) {
		int[] combine = combine(new int[] {1,2,3,4} , new int[] {3,4,5,6,8,10});
		for(int c : combine){
			System.out.print(c + " ");
		}

	}

}
