package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.4
 * ʹ������ָ�룬slow��fast��slowÿ���ƶ�һ��fastÿ���ƶ�����������ֻ�����ôfastһ�����slow������
 * ���û�л�����ôfast��Ȼ�ȷ��ʵ�null��
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
