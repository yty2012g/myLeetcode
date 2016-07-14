package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.14
 * ����һ��newHead���Ѳ�����val�����нڵ�����newHead�ϼ��ɡ�Ȼ�󷵻�newHead.next������ɾ���������
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
