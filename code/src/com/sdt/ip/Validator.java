package com.sdt.ip;

public class Validator {
	public final static String DOT = "\\.";
	public static boolean validate(String ip){
		if(ip == null || ip.equals(""))
			return false;
		String[] parts = ip.split(DOT);
		if (parts.length != 4) 
			return false;
		for(String part : parts){
			try {
				if(Integer.parseInt(part) < 0 || Integer.parseInt(part)> 255)
					return false;
			} catch (Exception e) {
				return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		String ip1 = "192.168.0.1";
		String ip2 = "0.0.0.0";
		String ip3 = "999.123.1234.2";
		String ip4 = "a.b.c.d";
		String ip5 = "1234";
		System.out.println(validate(ip1));
		System.out.println(validate(ip2));
		System.out.println(validate(ip3));
		System.out.println(validate(ip4));
		System.out.println(validate(ip5));
	}

}
