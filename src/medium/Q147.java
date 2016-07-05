package medium;

import java.util.*;

import basicDataStructure.ListNode;

/*
 * 2016.7.5
 * ����1������������������Ŀ��Ҫ�󣬲�������������õ����ƶ�ָ��ķ�ʽ����ȻҲ���Դ���һ���µ�����
 * ����2���������������O��n��ʱ�临�Ӷȣ�������洢��LinkedList����Ȼ�󣬵���Collections�������sort����������
 *                  ���O��n��ʱ�临�Ӷȣ�д��ԭʼ����  9ms����Ͳ�������ĿҪ���ˣ���Ϊ���ǲ��������ˡ�
 */
public class Q147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode newhead = new ListNode(0);
		ListNode newcopy = newhead;
		ListNode copy = head;
		while (copy != null) {
			ListNode next = copy.next;
			newcopy = newhead.next;
			if (newcopy == null) {
				newhead.next = copy;
				copy.next = null;
			} else {
				if (copy.val <= newcopy.val) {
					newhead.next = copy;
					copy.next = newcopy;
				} else {
					boolean flag = false;
					while (newcopy != null) {
						if (newcopy.val > copy.val) {
							flag = true;
							copy.next = newcopy.next;
							newcopy.next = copy;
							int t = newcopy.val;
							newcopy.val = copy.val;
							copy.val = t;
							break;
						}
						if (newcopy.next == null && !flag) {
							newcopy.next = copy;
							copy.next = null;
							newcopy = newcopy.next;
						}
						newcopy = newcopy.next;
					}
				}
			}
			copy = next;
		}
		return newhead.next;
	}

	public ListNode insertionSortList2(ListNode head) {
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
