package medium;

import basicDataStructure.ListNode;

/*
 * 2016.5.17
 * 使用两个链表，一个记录比x小的元素，一个记录大于等于x的元素，之所以使用两个链表是因为要求相关顺序要保持
 * 如果使用快速排序的partition方法，顺序无法保持。
 * 最后就是将两个链表连接在一起即可。
 */
public class Q86 {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode smallHead = new ListNode(0);
		ListNode otherHead = new ListNode(0);
		ListNode cs = smallHead;
		ListNode co = otherHead;
		while (head != null) {
			if (head.val < x) {
				smallHead.next = new ListNode(head.val);
				smallHead = smallHead.next;
			} else {
				otherHead.next = new ListNode(head.val);
				otherHead = otherHead.next;
			}
			head = head.next;
		}
		if (cs.next == null)
			return co.next;
		if (co.next == null)
			return cs.next;
		smallHead.next = co.next;
		return cs.next;
	}
}
