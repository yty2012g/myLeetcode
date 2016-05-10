package easy;

import java.util.Stack;

import basicDataStructure.ListNode;
/*
 * 2016.5.5
 * ʹ��һ������Ϊ2��ջ�����ջ�������ﵽ2����һ�ε�ջ������ջ�����ʽ��з�����
 * ���һ�Σ��ڻ�û�е�ջ֮ǰ�ͽ���ѭ�������������Ҫ��ջ��Ԫ�ض�������
 */
public class Q24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode copy = head;
		ListNode res = new ListNode(0);
		ListNode c = res;
		Stack<Integer> s = new Stack<Integer>();
		while (copy != null) {
			if (s.size() < 2) {
				s.push(copy.val);
				copy = copy.next;
			} else {
				while (!s.empty()) {
					res.next = new ListNode(s.pop());
					res = res.next;
				}
			}
		}
		while (!s.empty()) {
			res.next = new ListNode(s.pop());
			res = res.next;
		}
		return c.next;
	}
}
