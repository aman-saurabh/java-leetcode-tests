package com.tp.part03_longest_substring;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
	public static void main(String[] args) {
		String s = "pwwktpshew";
//		String s ="abcabcbb";
//		String s = "aab";
//		String s= "dvdf";
//		String s = "bbbbb";
		int len = getLongestSubstringLength(s);
		System.out.println(len);
	}
	
	private static int getLongestSubstringLength(String s) {
		/*
		// Method 1 :- Not optimal
		int len = 0;
		List<Character> uniqueChars = new ArrayList<>();
		for(int i = 0; i< s.length(); i++) {
			int index = uniqueChars.indexOf(s.charAt(i));
			if(index >= 0) {
				len = Math.max(len, uniqueChars.size());
				uniqueChars = uniqueChars.subList(index+1, uniqueChars.size());
			}
			uniqueChars.add(s.charAt(i));
		}
		return Math.max(len, uniqueChars.size());
		*/
		
		// Method 2 :-
		if(s.length() == 0) return 0;
		int len = 0, startIndex = 0, endIndex = 0;
		for(int i = 1; i< s.length(); i++) {
			int index = s.substring(startIndex, i).indexOf(s.charAt(i));
			if(index >= 0) {
				len = Math.max(len, (endIndex - startIndex)+1);
				startIndex += index + 1;
			}
			endIndex = i;
		}
		return Math.max(len, (endIndex - startIndex)+1);
	}
}
