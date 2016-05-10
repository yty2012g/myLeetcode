package hard;

import java.util.Stack;

import basicDataStructure.ListNode;

/*
 * 2016.5.5
 * ���Ҳ��̫�鷳��Ҫ�������ʣ��ĳ��ȴﲻ����ת�ĳ���k���򲻽��з�ת��
 * Ҳ�������ʣ���sջ�������������k������Ҫ��ת������Ĳ�����ʹ��s2ջ���Ƚ�sջ����������ε�����������s2ջ
 * s2ջ��˳��ͺ�s1ǡ���෴����s2�ĳ�ջ˳����ǲ�����ġ�
 * ��Ȼ����������һ������old��¼��һ�ε��������ݣ�ÿһ�Σ��ȵ���һ�����ݣ������ݵ�nextָ��old��Ȼ�����old
 * ��ջΪ��ʱ��res��nextָ��ָ��old���ɡ�
 */
public class Q25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return head;
		ListNode copy = head;
		ListNode res = new ListNode(0);
		ListNode c = res;
		Stack<Integer> s = new Stack<Integer>();
		while (copy != null) {
			if (s.size() < k) {
				s.push(copy.val);
				copy = copy.next;
			} else {
				while (!s.empty()) {
					res.next = new ListNode(s.pop());
					res = res.next;
				}
			}
		}
		if (s.size() == k) {
			while (!s.empty()) {
				res.next = new ListNode(s.pop());
				res = res.next;
			}
		} else {
			Stack<Integer> s2 = new Stack<Integer>();
			while (!s.empty()) {
				s2.push(s.pop());
			}
			while (!s2.empty()) {
				res.next = new ListNode(s2.pop());
				res = res.next;
			}
		}
		return c.next;
	}
}
