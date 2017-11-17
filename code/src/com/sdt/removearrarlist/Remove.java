package com.sdt.removearrarlist;

import java.util.ArrayList;
import java.util.Iterator;


public class Remove {
	public static void remove1(ArrayList<String> list){
		for(int i = list.size() - 1; i >= 0; i--){
			String string = list.get(i);
			if("b".equals(string)){
				list.remove(string);
			}
		}
	}
	public static void remove2(ArrayList<String> list){
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String string = iterator.next();
			if("b".equals(string)){
				iterator.remove();
			}
		}
	}
	public static void main(String[] args){
		
	}
}
