package com.tp.part19_remove_node_from_end;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveNodeFromEnd {
	public static void main(String[] args) {
		int[] ary = {1,2,3,4,5};
		ListNode head = getListNode(ary);
		int n = 2;
		RemoveNodeFromEnd lNode = new RemoveNodeFromEnd();
		ListNode l = lNode.removeNthFromEnd(head, n);
		System.out.println(getEquivalentList(l));
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ln = head;
        int length = 0;
        while (ln != null) {
			length ++;
			ln = ln.next;
		}
        int indexToRemove = length - (n);
        ln = head;
        int[] nums = new int[length - 1];
        for(int i = 0; i < length; i++) {
        	int j = i <= indexToRemove? i : i -1;
        	if(i < indexToRemove || i > indexToRemove) {
        		nums[j] = ln.val;
        	}
        	ln = ln.next;
        }
        return getListNode(nums);
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
