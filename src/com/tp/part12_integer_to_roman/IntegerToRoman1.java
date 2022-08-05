package com.tp.part12_integer_to_roman;

public class IntegerToRoman1 {
	public static void main(String[] args) {
		String s = integerToRoman(4838);
		System.out.println(s);
	}
	
	private static String integerToRoman(int num) {
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
		int updatedNum = num;
		int [] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
		String[] strVals = {"M", "CM", "D", "CD", "C", "XC",  "L", "XL", "X", "IX", "V", "IV", "I"};
		String val = "";
		for(int i =0; i < nums.length; i++) {
			int divisor = updatedNum / nums[i];
			for(int j = 0; j < divisor; j++) {
				val += strVals[i];
			} 
			updatedNum = updatedNum % nums[i]; 
		}
		return val;
	}
}
