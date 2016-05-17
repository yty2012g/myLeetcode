package medium;

import basicDataStructure.ListNode;

/*
 * 2016.5.17
 * ʹ����������һ����¼��xС��Ԫ�أ�һ����¼���ڵ���x��Ԫ�أ�֮����ʹ��������������ΪҪ�����˳��Ҫ����
 * ���ʹ�ÿ��������partition������˳���޷����֡�
 * �����ǽ���������������һ�𼴿ɡ�
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
