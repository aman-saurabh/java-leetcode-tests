package com.tp.part22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		int n = 4;
		GenerateParentheses gp = new GenerateParentheses();
		List<String> s = gp.generateParenthesis(n);
		System.out.println(s);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> vals= new ArrayList<>();
		backtrack(vals, "", 0, 0, n);
		return vals;
    }
	
	public void backtrack(List<String> vals, String current, int open, int close, int n) {
		if(current.length() == n*2) {
			vals.add(current);
			return;
		}
		
		if(open < n) {
			backtrack(vals, current+"(", open+1, close, n);
		}
		if(close < open) {
			backtrack(vals, current+")", open, close+1, n);
		}
	}
}
