package com.tp.part01_two_sum;

public class TwoSum1 {
	public static void main(String[] args) {
		int[] nums = {5, 1, 3, 4, 7, 6};
		int target = 13;
		int[] s = getSumToTargetElements(nums, target);
		System.out.println(s[0]+"***"+s[1]);
	}
	
	private static int[] getSumToTargetElements(int[] nums, int target) {
		int[] vals = new int[2];
		for(int i =0; i< nums.length; i++) {
			int sub = target - nums[i];
			boolean exit = false;
			if(i < (nums.length-1)) {
				for(int j = i+1; j < nums.length; j++) {
					if(sub == nums[j]) {
						vals[0] = i;
						vals[1] = j;
						exit = true;
						break;
					}
				}
			}
			if(exit == true) break;
		}
		return vals;
	}
}
