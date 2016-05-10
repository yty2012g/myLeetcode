package easy;

import java.util.Stack;

import basicDataStructure.ListNode;
/*
 * 2016.5.5
 * 使用一个容量为2的栈，如果栈的容量达到2，就一次弹栈，利用栈的性质进行反序列
 * 最后一次，在还没有弹栈之前就结束循环，所以最后需要将栈的元素都弹出；
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
