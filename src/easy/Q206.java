package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.14
 * �ȼ�¼ԭ�������һ��Ԫ�أ���Ϊnext��
 * ����ǰ�����nextָ��ָ��newhead��Ȼ��newhead��ɵ�ǰ�������Ԫ�ء�
 * ��󽫷��ʵ�Ԫ������Ϊnext���ɡ�
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
