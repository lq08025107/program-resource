package com.sdt.number;
/*
 * n的阶乘
 */
public class Fact {
	public static int fact(int n){
		if(n == 0) return 1;
		return n*fact(n-1);
	}
	public static void main(String[] args) {
		for(int i=0; i<12; i++){
			System.out.println(fact(i));
		}
		
	}

}
