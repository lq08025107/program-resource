package com.sdt.randomstring;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set noreapeat  =new TreeSet();
        Random rdm = new Random();  
        while (noreapeat.size()<20){
        	int  bb =Math.abs(rdm.nextInt())%26+97;
            char cc =(char)bb;
            noreapeat.add(cc);
       }
       System.out.println(noreapeat);
	}

}
