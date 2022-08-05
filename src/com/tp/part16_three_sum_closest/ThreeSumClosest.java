package com.tp.part16_three_sum_closest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumClosest {
	public static void main(String[] args) {
//		int[] nums = {-1,2,1,-4};
//		int[] nums = {0,0,0};
		int[] nums = {0,1,2};
		int target = 1;
		int sum = threeSumClosest(nums, target);
		System.out.println(sum);
	}
	
	private static int threeSumClosest(int[] nums, int target) {
		long d1 = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.sort(listNums);
		int closestSum = nums[0]+nums[1]+nums[2];  
		boolean exit = false;
		for(int i =0; i < nums.length-2; i++) {
			for(int j = i+1; j < nums.length-1; j++) {
				int remaining = target - (listNums.get(i) + listNums.get(j));
				List<Integer> subListNums = listNums.subList(j+1, listNums.size());
				int insertionPoint = Collections.binarySearch(subListNums, remaining);
				if(insertionPoint < 0) {
					insertionPoint = (-1) * insertionPoint - 1 + (j+1);
					int sum = 0;
					int diff = 0;
					if(insertionPoint < listNums.size()) {
						sum = listNums.get(i) + listNums.get(j) + listNums.get(insertionPoint);
						diff = target > sum? target - sum : sum - target;
					}
					if(insertionPoint - 1 > j) {
						int lowerSum = listNums.get(i) + listNums.get(j) + listNums.get(insertionPoint-1);
						int lowerSumDiff  = lowerSum > target? lowerSum - target : target - lowerSum;
						if(diff == 0 || diff > lowerSumDiff) {
							sum = lowerSum;
							diff = lowerSumDiff;
						}
					}
					int closestDiff = closestSum > target ? closestSum - target : target - closestSum;
					
					if(diff < closestDiff) {
						closestSum = sum;
					}
				} else {
					closestSum = listNums.get(i) + listNums.get(j) + listNums.get((j+1)+insertionPoint);
					exit = true;
				}
				
				if(exit == true) break;
			}
			if(exit == true) break;	
		}
		long d2 = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.println(d2 - d1);
		return closestSum;
		
		//Following implementation is exactly same as the previous one. Actually in previous solution I had converted array to list and then performed binary search.
		//In the following example I didn't converted it into list and directly applied binary search on it thinking that it would take less processing time.
		//But the result was completely opposite. Even it throw "Time Limit Exceeded" exception on leetcode while the above solution didn't.
		//Update :- On running above solution also again and again in leetcode it also throw "Time Limit Exceeded" exception several times.
		
		/*
		Arrays.sort(nums);
		int closestSum = nums[0]+nums[1]+nums[2];  
		boolean exit = false;
		for(int i =0; i < nums.length-2; i++) {
			for(int j = i+1; j < nums.length-1; j++) {
				int remaining = target - (nums[i] + nums[j]);
				int[] subNums = Arrays.copyOfRange(nums, j+1, nums.length);
				int insertionPoint = Arrays.binarySearch(subNums, remaining);
				if(insertionPoint < 0) {
					insertionPoint = (-1) * insertionPoint - 1 + (j+1);
					int sum = 0;
					int diff = 0;
					if(insertionPoint < nums.length) {
						sum = nums[i] + nums[j] + nums[insertionPoint];
						diff = target > sum? target - sum : sum - target;
					}
					if(insertionPoint - 1 > j) {
						int lowerSum = nums[i] + nums[j] + nums[insertionPoint - 1];
						int lowerSumDiff  = lowerSum > target? lowerSum - target : target - lowerSum;
						if(diff == 0 || diff > lowerSumDiff) {
							sum = lowerSum;
							diff = lowerSumDiff;
						}
					}
					int closestDiff = closestSum > target ? closestSum - target : target - closestSum;
					
					if(diff < closestDiff) {
						closestSum = sum;
					}
				} else {
					closestSum = nums[i] + nums[j] + nums[(j+1)+insertionPoint];
					exit = true;
				}
				
				if(exit == true) break;
			}
			if(exit == true) break;	
		}
		return closestSum;
		*/
		
	}
}
