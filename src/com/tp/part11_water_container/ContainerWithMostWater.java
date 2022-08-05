package com.tp.part11_water_container;

public class ContainerWithMostWater {
	
	
	public static void main(String[] args) {
//		int[] height = {1,8,6,2,5,4,8,3,7};
//		int[] height = {1,1};
		int[] height = {1,2,1,1,1,17,18,3,2,1};
		int cap = getMaxCapacity(height);
		System.out.println(cap);
	}
	
	private static int getMaxCapacity(int[] height) {
//		int capacity = 0;
//		for(int i = 0; i< height.length; i++) {
//			for(int j = i; j< height.length; j++) {
//				capacity = Math.max(capacity, (Math.min(height[i], height[j]) * (j-i)));
//			}
//		}
//		return capacity;
		int capacity = 0, l = 0, r = height.length - 1;
		while(l < r) {
			int currentCapacity = Math.min(height[l], height[r]) * (r - l);
			capacity = Math.max(capacity, currentCapacity);
			if(height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return capacity;
		
	}
	
	
}
