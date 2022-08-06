package com.tp.part21_merge_sorted_lists;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortedLists {
	public static void main(String[] args) {
		ListNode list1 = getListNode(new int[]{1,2,4});
		ListNode list2 = getListNode(new int[]{1,3,4});
		MergeSortedLists merge = new MergeSortedLists();
		ListNode l = merge.mergeTwoLists(list1, list2);
		System.out.println(getEquivalentList(l));
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        ListNode l = list1;
        while (l != null) {
        	list.add(l.val);
        	l = l.next;
		}
        
        l = list2;
        while (l != null) {
        	int index = list.size();
        	for(int i=0; i < list.size(); i++) {
        		if(list.get(i) > l.val) {
        			index = i;
        			break;
        		}
        	}
        	list.add(index, l.val);
        	l = l.next;
		}
        return getListNodeFromList(list);
    }
	
	public static ListNode getListNodeFromList(List<Integer> ary) {
		ListNode l = null;
		for(int i = (ary.size() - 1); i >=0; i--) {
			ListNode l1 = new ListNode(ary.get(i));
			if(i != (ary.size() - 1)) {
				l1.next = l;
			}
			l = l1;
		}
		return l;
	}
	
	public static ListNode getListNode(int[] ary) {
		ListNode l = null;
		for(int i = (ary.length - 1); i >=0; i--) {
			ListNode l1 = new ListNode(ary[i]);
			if(i != (ary.length - 1)) {
				l1.next = l;
			}
			l = l1;
		}
		return l;
	}
		
	public static List<Integer> getEquivalentList(ListNode l){
		List<Integer> list = new ArrayList<>();
		ListNode l1 = l;
		while (l1 != null) {
			list.add(l1.val);
			l1 = l1.next;
		}
		return list;
	}
}
