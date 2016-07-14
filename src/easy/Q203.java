package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.14
 * 建立一个newHead，把不等于val的所有节点连在newHead上即可。然后返回newHead.next，就是删除后的链表。
 */
public class Q203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode newhead = new ListNode(0);
		ListNode newcopy = newhead;
		ListNode copy = head;
		while (copy != null) {
			if (copy.val != val) {
				newcopy.next = copy;
				newcopy = newcopy.next;
			}
			copy = copy.next;
		}
		newcopy.next = null;
		return newhead.next;
	}
}
