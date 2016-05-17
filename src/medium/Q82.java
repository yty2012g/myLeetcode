package medium;

import basicDataStructure.*;

/*
 * 2016.5.17
 * ʹ������ָ�룬startָ���endָ�룬ָ���ظ��������β��
 * ������ֵ�ǰ������һ���ڵ��ֵ����ȵ�������������ָ�룬�������ָ�����غϵģ�����û�г����ظ�������ǰ�����������ɡ�
 * ���ָ�벻�غϣ���ָ�뻹ԭ������������ǰ��㡣
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
