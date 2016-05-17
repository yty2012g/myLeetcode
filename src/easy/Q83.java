package easy;

import basicDataStructure.*;

/*
 * 2016.5.17
 * 如果当前元素的值等于下一个元素的值，则直接将当前元素的next指针指向下一个元素next指针指向的对象，相当于跳过当前元素的下一个元素。
 * 如果不等于，则当前元素变成下一个元素。
 * 终止的条件：当前元素是null(最后一个元素是重复的元素)，当前元素的下一个元素为空(最后一个元素不是重复的元素)
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
