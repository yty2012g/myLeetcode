package medium;

import basicDataStructure.ListNode;

/*
 * 2016.7.4
 * 在Q141的基础上，从碰撞点开始，slow还原到head的位置，然后slow和fast每次都只移动一格，相遇点为环的起始点。
 * 假设环的起始点距离k，环的长度为n。不妨假设n>k
 * 当slow到达环的起始点时，fast距离环的起始点为k。此时，可以看作fast和slow做同向运动。
 * 此时fast和slow相距n-k。因此fast要追上slow，需要走n-k步，相遇后，相遇点向后距离碰撞点为n-k，向前距离碰撞点为k。
 * 此时让slow回到原点，所以slow和fast都距离碰撞点为k，再次相遇时，就是环的起点。
 */
public class Q142 {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
