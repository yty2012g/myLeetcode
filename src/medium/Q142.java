package medium;

import basicDataStructure.ListNode;

/*
 * 2016.7.4
 * ��Q141�Ļ����ϣ�����ײ�㿪ʼ��slow��ԭ��head��λ�ã�Ȼ��slow��fastÿ�ζ�ֻ�ƶ�һ��������Ϊ������ʼ�㡣
 * ���軷����ʼ�����k�����ĳ���Ϊn����������n>k
 * ��slow���ﻷ����ʼ��ʱ��fast���뻷����ʼ��Ϊk����ʱ�����Կ���fast��slow��ͬ���˶���
 * ��ʱfast��slow���n-k�����fastҪ׷��slow����Ҫ��n-k������������������������ײ��Ϊn-k����ǰ������ײ��Ϊk��
 * ��ʱ��slow�ص�ԭ�㣬����slow��fast��������ײ��Ϊk���ٴ�����ʱ�����ǻ�����㡣
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
