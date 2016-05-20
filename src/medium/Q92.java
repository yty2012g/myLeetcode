package medium;

import basicDataStructure.ListNode;
import java.util.*;

/*
 * 2016.5.20
 * 首先找到m前的元素记为before，然后从m开始将链表顺序反序，一直到第n个元素，第n+1个元素记为after
 * before的next指向反序部分的结尾，因此需要将反序部分结尾的next指针指向after
 * 然后将before的next指针指向反序部分的开头，就改变了链表的格式。
 */
public class Q92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode before = new ListNode(0);
		ListNode after = new ListNode(0);
		ListNode old = new ListNode(0);
		ListNode copy = head;
		if (m == 1) {
			old.next = head;
			return reverseBetween(old, m + 1, n + 1).next;
		}
		int i = 1;
		while (copy != null) {
			if (i == m - 1) {
				before = copy;
				copy = copy.next;
				i++;
				old = copy;
				copy = copy.next;
				i++;
				while (i != n + 1) {
					ListNode ne = copy.next;
					copy.next = old;
					old = copy;
					copy = ne;
					i++;
				}
				after = copy;
				before.next.next = after;
				before.next = old;
				break;
			}
			copy = copy.next;
			i++;
		}
		return head;
	}
}
