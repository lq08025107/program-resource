package com.sdt.number;

import java.util.ArrayList;
import java.util.List;


public class Prime {
	//求素数质数 只能被1和自己本身整除
	public static List<Integer> getPrime(int start, int end){
		if(start <=0 || end <= 0 || start > end) throw new RuntimeException();
		List<Integer> result = new ArrayList<>();
		for(int i = start; i<= end; i++){
			int j = 2;
			while(j < i){
				if(i%j == 0) break;
				j++;
			}
			if(i == j) result.add(i);
		}
		return result;
	}
	public static void main(String[] args){
		List<Integer> results = getPrime(20, 200);
		for(Integer r : results){
			System.out.println(r);
		}
		System.out.println(17<<1);
	}
}
