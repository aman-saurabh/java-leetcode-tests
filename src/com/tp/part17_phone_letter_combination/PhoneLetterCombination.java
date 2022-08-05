package com.tp.part17_phone_letter_combination;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombination {
	public static void main(String[] args) {
		String num = "2349";
		List<String> res = letterCombinations(num);
		System.out.println(res);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		
		Map<String, List<String>> map = Map.ofEntries(
				new AbstractMap.SimpleEntry<String, List<String>>("2", List.of("a", "b","c")),
				new AbstractMap.SimpleEntry<String, List<String>>("3", List.of("d", "e", "f")),
				new AbstractMap.SimpleEntry<String, List<String>>("4", List.of("g", "h", "i")),
				new AbstractMap.SimpleEntry<String, List<String>>("5", List.of("j", "k", "l")),
				new AbstractMap.SimpleEntry<String, List<String>>("6", List.of("m", "n", "o")),
				new AbstractMap.SimpleEntry<String, List<String>>("7", List.of("p", "q", "r", "s")),
				new AbstractMap.SimpleEntry<String, List<String>>("8", List.of("t", "u", "v")),
				new AbstractMap.SimpleEntry<String, List<String>>("9", List.of("w", "x", "y", "z"))
		);
		for(int i=0; i< digits.length(); i++) {
			String s = Character.toString(digits.charAt(i));
			List<String> l = map.get(s);
			if(res.size() == 0) {
				res = l;
			} else {
				List<String> old = res;
				res = new ArrayList<>();
				for(String str : old) {
					for(String n: l) {
						res.add(str+n);
					}
				}
			}
		}
		
		return res;
	}	
}
