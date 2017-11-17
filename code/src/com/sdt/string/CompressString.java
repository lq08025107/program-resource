package com.sdt.string;
/**
 * 实现这样的功能 aaabbbccc ——> a3b3c3
 * @author liuqiang
 *
 */
public class CompressString {
	public static String compress(String origin){
		StringBuilder returnString = new StringBuilder();
		int p1 = 0; int count = 1; int length = origin.length();
		while(p1 < length){
			if(p1+1 < length && origin.charAt(p1) == origin.charAt(p1+1)){
				count = 1;  
                int p2 = p1+1;  
                while(p2 < length && origin.charAt(p2) == origin.charAt(p1)){  
                    count++; 
                    p2++;
                }    
				returnString.append(origin.charAt(p1));
				returnString.append(count);
				p1 = p2;
			}
			else{
				returnString.append(origin.charAt(p1));
				returnString.append(1);
				p1++;
			}
		}
		return returnString.toString();
	}

	public static void main(String[] args) {
		String origin = "aaaabbccca";
		System.out.println(origin);
		System.out.println(compress(origin));

	}

}
