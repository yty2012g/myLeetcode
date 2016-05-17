package medium;

import basicDataStructure.*;

/*
 * 2016.5.17
 * 使用两个指针，start指针和end指针，指向重复链表的收尾。
 * 如果出现当前结点和下一个节点的值不想等的情况，检查两个指针，如果两个指针是重合的，表明没有出现重复，将当前结点加入结果即可。
 * 如果指针不重合，则将指针还原，并且跳过当前结点。
 */
public class Q82 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode copy = head;
		ListNode newHead = new ListNode(0);
		ListNode newcopy = newHead;
		int start = 0;
		int end = start;
		while (copy.next != null) {
			if (copy.val == copy.next.val) {
				end++;
			} else {
				if (start == end) {
					newHead.next = copy;
					newHead = newHead.next;
				} else {
					start = 0;
					end = start;
				}
			}
			copy = copy.next;
		}
		if (start == end) {
			newHead.next = copy;
			newHead = newHead.next;
		} else {
			newHead.next = null;
		}
		return newcopy.next;
	}
}
