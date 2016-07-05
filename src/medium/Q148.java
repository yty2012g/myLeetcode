package medium;

import basicDataStructure.ListNode;
import java.util.*;

/*
 * 2016.7.5
 * ��Q147�е����ƣ���listnode������LinkedList������Collections�ķ�����
 */
public class Q148 {
	public ListNode sortList(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode copy = head;
		while (copy != null) {
			list.add(copy.val);
			copy = copy.next;
		}
		Collections.sort(list);
		copy = head;
		int count = 0;
		while (copy != null) {
			copy.val = list.get(count);
			count++;
			copy = copy.next;
		}
		return head;
	}
}
