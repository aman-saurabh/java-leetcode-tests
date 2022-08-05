package com.tp.part09_palindrome_number;

public class PalindromeNumber1 {
	public static void main(String[] args) {
		boolean i = isPalindromeNum(1596951);
		System.out.println(i);
	}
	
	public static boolean isPalindromeNum(int x) {
		int num = x;
		long revNum = 0;
		if(num < 0 || (num%10 == 0 && num !=0)) {
			return false;
		} else if(num == 0) {
			return true;
		}
		
		while(num > 0) {
			revNum = revNum * 10 + num % 10;
			num /= 10;
		}
		
		return x == revNum;
	}
}
