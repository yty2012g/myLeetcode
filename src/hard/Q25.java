package hard;

import java.util.Stack;

import basicDataStructure.ListNode;

/*
 * 2016.5.5
 * 这个也不太麻烦，要点是如果剩余的长度达不到反转的长度k，则不进行反转。
 * 也就是最后剩余的s栈如果容量不等于k，则不需要反转，这里的操作是使用s2栈，先将s栈里的数据依次弹出并放置在s2栈
 * s2栈的顺序就和s1恰好相反，则s2的出栈顺序就是不反序的。
 * 当然，可以利用一个变量old记录上一次弹出的数据，每一次，先弹出一个数据，此数据的next指向old，然后更新old
 * 当栈为空时，res的next指针指向old即可。
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
