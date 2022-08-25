package com.tp.part23_merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeKSortedLists {
	public static void main(String[] args) {
		MergeKSortedLists mksl = new MergeKSortedLists();
		int[][] nums = {{1,4,5}, {1,3,4}, {2,6}};
		ListNode[] lists = mksl.getArrayOfListNode(nums);
		ListNode lNode = mksl.mergeKLists(lists);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode l: lists) {
        	list.addAll(listNodeToList(l));
        }
        Collections.sort(list);
        return listToListNode(list);
    }
	
	private List<Integer> listNodeToList(ListNode ln) {
		List<Integer> list = new ArrayList<>();
		ListNode l = ln;
		while (l != null) {
			list.add(l.val);
			l = l.next;
		}
		return list;
	}
	
	private ListNode listToListNode(List<Integer> list) {
		ListNode l = null;
		for(int i = (list.size() - 1); i>=0; i--) {
			ListNode ln = new ListNode(list.get(i));
			if(l != null) {
				ln.next = l;
			}
			l = ln;
		}
		return l;
	}
	
	
	//-----------------Used for constructing question-------------
	
	private ListNode[] getArrayOfListNode(int[][] nums) {
		ListNode[] lists = new ListNode[nums.length];
		for(int i =0; i < nums.length; i++) {
			lists[i] = getListNode(nums[i]);
		}
		return lists;
	}
	
	private ListNode getListNode(int[] ary) {
		ListNode l = null;
		for(int i = (ary.length - 1); i>=0; i--) {
			ListNode l1 = new ListNode(ary[i]);
			if(l != null) {
				l1.next = l;
			}
			l = l1;
		}
		return l;
	}
}
