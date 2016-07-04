package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.4
 * 使用两个指针，slow和fast。slow每次移动一格，fast每次移动两格，如果出现环，那么fast一定会和slow相遇。
 * 如果没有环，那么fast必然先访问到null。
 */
public class Q141 {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
