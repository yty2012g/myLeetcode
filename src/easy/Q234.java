package easy;

import basicDataStructure.ListNode;
import java.util.*;

/*
 * 2016.7.19
 * �����������arraylist�洢������Ȼ��ԳƱȽϼ��ɡ�
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
