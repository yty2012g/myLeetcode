package medium;

import java.util.*;
import basicDataStructure.*;

/*
 * 2016.5.15
 * 如果要将链表的最后k个元素移到前面，等价于将前面（num-k）个元素移到结尾。
 * 所以第一个遍历得到了元素的数量num和结尾元素end
 * 然后就是每次将头元素放到结尾元素，变成新的结尾元素。注意放到结尾元素的时候，需要将next指针指向null，否则会出现循环链表的问题。
 */
public class Q61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int num = 0;
		ListNode end = head;
		ListNode copy = head;
		while (copy.next != null) {
			copy = copy.next;
			num++;
		}
		num++;
		if (k % num == 0)
			return head;
		end = copy;
		for (int i = 0; i < num - (k % num); i++) {
			ListNode temp = head.next;
			end.next = head;
			end = end.next;
			end.next = null;
			head = temp;
		}
		return head;
	}
}
