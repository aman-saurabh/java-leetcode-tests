package com.tp.part02_add_two_numbers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
	public static ListNode getListNode(int[] ary) {
		ListNode l = new ListNode();
		for(int i = ary.length; i >0; i--) {
			if(i == ary.length) {
				l = new ListNode(ary[i - 1], null);
			} else {
				l = new ListNode(ary[i - 1], l);
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		int[] v1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};	
		int[] v2 = {5,6,4};
		//int[] v1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,1};
		//int[] v2 = {5,6,4};
		ListNode l1 = getListNode(v1);
		ListNode l2 = getListNode(v2);

		ListNode l = addTwoNumbers(l1, l2);
		ListNode lnext = l;
		List<Integer> list = new ArrayList<>();
		while (lnext != null) {
			list.add(lnext.val);
			lnext = lnext.next;
		}
		System.out.println(list);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigDecimal sum = getReverseVal(l1).add(getReverseVal(l2));
		BigDecimal newVal = sum;
		List<Integer> list = new ArrayList<>();
		ListNode l = new ListNode(0);
		while (newVal.compareTo(new BigDecimal("1")) >= 0) {
			BigDecimal v = newVal.remainder(new BigDecimal("10"));
			list.add(v.intValue());
			newVal = newVal.divide(new BigDecimal("10"));
		}
		for(int i = list.size(); i > 0; i--) {
			if(i == list.size()) {
				l = new ListNode(list.get(i-1), null);
			} else {
				l = new ListNode(list.get(i-1), l);
			}
		}
		return l;
	}
	
	private static BigDecimal getReverseVal(ListNode l) {
		BigDecimal val = new BigDecimal(0);
		ListNode node = l;
		int iteration = 0;
		while(node != null) {
			String s = String.valueOf(node.val * Math.pow(10, iteration));
			BigDecimal val1 = new BigDecimal(s);
			val = val.add(val1);
			node = node.next;	
			iteration++;
		}
		return val;
	}
}
