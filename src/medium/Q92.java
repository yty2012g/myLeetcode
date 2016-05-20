package medium;

import basicDataStructure.ListNode;
import java.util.*;

/*
 * 2016.5.20
 * �����ҵ�mǰ��Ԫ�ؼ�Ϊbefore��Ȼ���m��ʼ������˳����һֱ����n��Ԫ�أ���n+1��Ԫ�ؼ�Ϊafter
 * before��nextָ���򲿷ֵĽ�β�������Ҫ�����򲿷ֽ�β��nextָ��ָ��after
 * Ȼ��before��nextָ��ָ���򲿷ֵĿ�ͷ���͸ı�������ĸ�ʽ��
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
