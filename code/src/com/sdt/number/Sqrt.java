package com.sdt.number;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/*
 * 实现sqrt
 */
public class Sqrt {
	//二分法
	public static double sqrt(double target, Double prec){
		if (target < 0) {
			throw new RuntimeException();
		}
		double precise = (prec != null ? prec : 1e-7);  
		double low = 0, high = target, middle = 0, squre = 0;
		while(high-low > precise){
			middle = (high + low)/2;
			squre = middle * middle;
			if (squre < target)
				low = middle;
			if(squre > target)
				high = middle;
		}
		return (high + low)/2;
	}
	//newton
	public static double sqrt1(double target, Double prec){
		if (target < 0) {
			throw new RuntimeException();
		}
		double precise = (prec != null ? prec : 1e-7);
		double x = target;
		while (Math.abs() > precise) {
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(40000, 1e-7));
		System.out.println(Math.sqrt(40000));
		
	}

}
