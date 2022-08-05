package com.tp.part07_reverse_integer;

public class ReverseInteger1 {
	public static void main(String[] args) {
		int s = getReverseInt(1465546569);
		System.out.println(s);
	}
	
	private static int getReverseInt(int x) {
		int val = x;
		if(x < 0) {
			val = -1 * x;
		}
		
		long revInt = 0;
		while(val > 0) {
			revInt = revInt * 10 + val % 10;
			val /= 10;
		}
		System.out.println(revInt);
		if(revInt > Integer.MAX_VALUE) {
			revInt = 0;
		}
		return (int) revInt * (x < 0? -1:1);
	}
}
