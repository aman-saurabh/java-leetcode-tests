package com.tp.part06_zigzag_conversion;


public class ZigzagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String res = convert("A", 2);
		System.out.println(res);
	}
	
	private static String convert(String s, int numRows) {
		if(numRows == 1 || s.length() < numRows) {
			return s;
		}
		String result = "";
		for(int i =0; i < numRows; i++) {
			//int baseMultiplier = (2*(numRows - 1) - i*2);
			//Above and following both value for baseMultiplier is correct.
			int baseMultiplier = numRows + (numRows-2) - i*2;
			int completedLength = i;
			result += s.charAt(i);
			while(completedLength < s.length()) {
				int first = completedLength + baseMultiplier;
				if(first != completedLength && first < s.length()) {
					result += s.charAt(first);
				}
				int second = first + i*2;
				if(second != first && second < s.length()) {
					result += s.charAt(second);
				}
				completedLength = second; 
			}
		}
		return result;
	}
	// n = rowSize, r = rowNumber
	//FIRST ROW
	//0,4,8,12 -> 3,14 								4-> (n + (n-2) - r*2), (r*2)  
	//0,6,12 -> 4,14    							6 ***
	//0,8,(16) -> 5, 14   							8
	//0,10, (20) -> 6, 14							10
	//SECOND ROW
	//1, 3, 5, 7, 9, 11, 13 -> 3, 14				2,2
	//1, 5, 7, 11, 13 -> 4,14						4,2 *** 
	//1, 7, 9, (15,17) -> 5, 14  					6,2
	//1, 9 ,11										8,2
	//THIRD ROW
	//2, 6, 10 -> 3, 14								4, 4
	//2, 4, 8, 10 -> 4, 14							2, 4 *** 
	//2, 6, 10, (14) -> 5, 14						4, 4
	//2, 8, 12, (18, 22) -> 6, 14					6, 4
	
	//Fourth row
	//3, 9 -> 4, 14									0, 6
	
	//P       H
	//A     S I
	//Y   I   R
	//P L     I  G
	//A       N 
	
	//P          R
	//A        I I
	//Y      H   N
	//P    S     G
	//A  I
	//L  
	//(2(n-1) - r*2), (r*2)
	//(n + (n-2) - r*2), (r*2)
}
