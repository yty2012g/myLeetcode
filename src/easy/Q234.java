package easy;

import basicDataStructure.ListNode;
import java.util.*;

/*
 * 2016.7.19
 * 把这个链表用arraylist存储起来。然后对称比较即可。
 */
public class Q234 {
	public boolean isPalindrome(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode copy = head;
		while (copy != null) {
			list.add(copy.val);
			copy = copy.next;
		}
		if (list.size() == 0 || list.size() == 1)
			return true;
		int small = 0;
		int big = list.size() - 1;
		while (small < big) {
			if (!list.get(small).equals(list.get(big)))
				return false;
			small++;
			big--;
		}
		return true;
	}
}
