package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.6
 * 很简单的题目。
 * 首先遍历两个链表，得到长度和最后一个节点。如果最后一个节点不想等，说明没有相交。
 * 如果相交的情况下，将较长的链表先遍历n个节点，n等于两个链表的长度的差值。然后两个链表同时遍历，当遍历到同一个节点时返回。
 */
public class Q160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int numA = 0;
		int numB = 0;
		ListNode copyA = headA;
		ListNode copyB = headB;
		ListNode endA = headA;
		ListNode endB = headB;
		while (copyA != null) {
			numA++;
			if (copyA.next == null)
				endA = copyA;
			copyA = copyA.next;
		}
		while (copyB != null) {
			numB++;
			if (copyB.next == null)
				endB = copyB;
			copyB = copyB.next;
		}
		if (endA != endB)
			return null;
		copyA = headA;
		copyB = headB;
		if (numA > numB) {
			for (int i = 0; i < numA - numB; i++) {
				copyA = copyA.next;
			}
		} else if (numA < numB) {
			for (int i = 0; i < numB - numA; i++) {
				copyB = copyB.next;
			}
		}
		while (copyA != copyB) {
			copyA = copyA.next;
			copyB = copyB.next;
		}
		return copyA;
	}
}
