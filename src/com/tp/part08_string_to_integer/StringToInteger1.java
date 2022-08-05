package com.tp.part08_string_to_integer;

public class StringToInteger1 {
	public static void main(String[] args) {
		int s = strToInt("+1");
		System.out.println(s);
	}
	
	private static int strToInt(String s) {
		double val = 0;
		String updatedString = s.trim();
		char sign = '+';
		if(updatedString.length() >=1){
			char first = updatedString.charAt(0);
			System.out.println(first);
			if(first == '-' || first == '+') {
				sign = first;
				updatedString = updatedString.substring(1, updatedString.length());
			}
		}
		if(updatedString.length() >=1) {
			boolean isString = true;
			int currentIndex = 0;
			while (isString) {
				if(currentIndex +1 == updatedString.length()) {
					isString = false;
				}
				char c = updatedString.charAt(currentIndex);
				if(Character.isDigit(c)) {
					val = val * 10 + Character.getNumericValue(c);
					if(isString == true) currentIndex += 1;
				} else {
					if(isString == true) isString = false;
				}
			}
		}
		val = val * (sign == '-'? -1: 1);
		if(val <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else if(val >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return (int) val;
		}
	}
}
