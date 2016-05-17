package easy;

import basicDataStructure.*;

/*
 * 2016.5.17
 * �����ǰԪ�ص�ֵ������һ��Ԫ�ص�ֵ����ֱ�ӽ���ǰԪ�ص�nextָ��ָ����һ��Ԫ��nextָ��ָ��Ķ����൱��������ǰԪ�ص���һ��Ԫ�ء�
 * ��������ڣ���ǰԪ�ر����һ��Ԫ�ء�
 * ��ֹ����������ǰԪ����null(���һ��Ԫ�����ظ���Ԫ��)����ǰԪ�ص���һ��Ԫ��Ϊ��(���һ��Ԫ�ز����ظ���Ԫ��)
 */
public class Q83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode copy = head;
		while (copy == null || copy.next != null) {
			if (copy.val == copy.next.val) {
				copy.next = copy.next.next;
			} else {
				copy = copy.next;
			}
		}
		return head;
	}
}
