package com.tp.part13_roman_to_integer;

public class RomanToInteger1 {
	
	public static void main(String[] args) {
		int s = romanToInteger("MCMXCIV");
		System.out.println(s);
	}
	
	/*
	 Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
	 */
	
	static int romanToInteger(String s) {
		int val = 0;
		for(int i =s.length() - 1; i >=0; i--) {
			switch (s.charAt(i)) {
			case 'M':
				val += 1000;
				break;
			case 'D':
				val += 500;
				break;
			case 'C':
				val += 100 * (val >= 500? -1 : 1);
				break;
			case 'L':
				val += 50;
				break;
			case 'X':
				val += 10 * (val >= 50? -1 : 1);
				break;
			case 'V':
				val += 5;
				break;
			case 'I':
				val += (val >= 5? -1 : 1);
				break;
			default:
				break;
			}
		}
		return val;
	}
}
