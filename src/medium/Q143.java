package medium;

import basicDataStructure.ListNode;
import java.util.*;

/*
 * 2016.7.4
 * ���˱��취����ÿһ���ڵ㶼��¼��hashmap��
 * ���չ�����������ָ�뼴�ɡ���19ms
 */
public class Q143 {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		ListNode cur = head;
		int count = 0;
		int max = 0;
		while (cur != null) {
			map.put(count, cur);
			if (count > max)
				max = count;
			count++;
			cur = cur.next;
		}
		int start = 0;
		int end = max;
		System.out.println(max);
		cur = new ListNode(0);
		while (start < end) {
			cur.next = map.get(start);
			cur = cur.next;
			cur.next = map.get(end);
			cur = cur.next;
			start++;
			end--;
		}
		if (start == end) {
			cur.next = map.get(start);
			cur = cur.next;
			cur.next = null;
		} else {
			cur.next = null;
		}
	}
}
