package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.14
 * 先记录原链表的下一个元素，记为next。
 * 将当前链表的next指针指向newhead，然后newhead变成当前链表访问元素。
 * 最后将访问的元素设置为next即可。
 */
public class Q206 {
	public ListNode reverseList(ListNode head) {
		ListNode copy = head;
		ListNode newhead = null;
		while (copy != null) {
			ListNode next = copy.next;
			copy.next = newhead;
			newhead = copy;
			copy = next;
		}
		return newhead;
	}
}
