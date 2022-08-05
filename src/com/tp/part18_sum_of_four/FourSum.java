package com.tp.part18_sum_of_four;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourSum {
	public static void main(String[] args) {
//		int[] nums = {1,0,-1,0,-2,2};
//		int[] nums = {2,2,2,2,2};
//		int target = 0;
//		int[] nums = {-491,-468,-450,-415,-414,-374,-357,-333,-305,-292,-274,-272,-271,-258,-241,-240,-227,-217,-196,-184,-161,-120,-116,-110,-110,-98,-92,-47,-27,-10,-8,-7,-4,-1,19,30,53,62,64,65,137,138,145,160,178,179,209,221,243,270,279,283,290,291,305,308,322,345,354,357,365,366,368,371,376,381,381,394,400,406,429,433,445,446,449,470,471,472};
//		int target = 2873;
		int[] nums = {1000000000,1000000000,1000000000,1000000000};
		int target = -294967296;
		List<List<Integer>> res = fourSum(nums, target);
		System.out.println(res);
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		long d1 = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int previousI = 0;
		for(int i =0; i< nums.length -3; i++) {
			if(i == 0) {
				previousI = nums[i];
			} else {
				if(nums[i] == previousI) {
					continue;
				} else {
					previousI = nums[i];
				}
			}
			
			int previousJ = 0;
			for(int j =i+1; j< nums.length -2; j++) {
				if(j == i+1) {
					previousJ = nums[j];
				} else {
					if(nums[j] == previousJ) {
						continue;
					} else {
						previousJ = nums[j];
					}
				}
				int previousK = 0;
				for(int k =j+1; k< nums.length -1; k++) {
					if(k == j+1) {
						previousK = nums[k];
					} else {
						if(nums[k] == previousK) {
							continue;
						} else {
							previousK = nums[k];
						}
					}
					//Method1
					/*
					int s = target - (nums[i] + nums[j] + nums[k]);
					int[] subNums = Arrays.copyOfRange(nums, k+1, nums.length);
					boolean isContain = Arrays.stream(subNums).anyMatch(e -> e == s);
					if(isContain) {
						//List<Integer> l = List.of(nums[i], nums[j], nums[k], s);
						//List<Integer> l = Stream.of(nums[i], nums[j], nums[k], s).collect(Collectors.toList());
						List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k], s);
						if(!res.contains(l)) {
							res.add(l);
						}
					}
					Method1 may be not working now as I have changed alot in above code.
					*/
					//Method2
					boolean exit = false;
					for(int l =k+1; l< nums.length; l++) {
						long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
						if(sum == target) {
							List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
							if(!res.contains(ans)) {
								res.add(ans);
								exit = true;
							}
						}
						if(exit == true) break;
					}
				}
				
				
			}
		}
		long d2 = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.println(d2 - d1);
		return res;
	}
}
