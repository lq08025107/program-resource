/**
 * 
 */
package com.sdt.randomstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


/**
 * 随机产生20个字符串并且字符串不能重复 且进行排序 
 * @author liuqiang
 *
 */
public class RandomDemo {

	/**
	 * @param args
	 */
	public static String getString(int n) {
		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
		Random ran = new Random();  
		char[] ca = new char[n];
		for (int i = 0; i < ca.length; i++) {  
			ca[i] = s.charAt(ran.nextInt(62));  
		}  
		return new String(ca);  
	}
	//treeset本身就有排序和去重作用
	public static String[] getStrings(int n){
		String[] myStrings = new String[n];
		Set stringset = new TreeSet();
		while(stringset.size() < n){
			stringset.add(getString(10));
		}
		Object[] strings = stringset.toArray();
		for(int i = 0; i < strings.length; i++){
			myStrings[i] = (String)strings[i];
		}
		return myStrings;
	}
	public static void main(String[] args) {
		String[] sa = getStrings(100);   
	    for (int i = 0; i < sa.length; i++) {  
	     System.out.println(sa[i]);  
	    }  

	}

}
