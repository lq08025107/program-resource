package com.sdt.string;
/**
 * 实现倒转字符串 abcde ——> edcba
 * @author liuqiang
 *
 */
public class ConvertString {
	public static String convert(String origin){
		StringBuilder ret = new StringBuilder();
		for(int i = origin.length() -1; i >= 0; i--){
			ret.append(origin.charAt(i));
		}
		return ret.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String origin = "abcde";
		System.out.println(origin);
		System.out.println(convert(origin));
	}

}
