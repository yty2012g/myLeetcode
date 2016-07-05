package medium;

import java.util.*;

import basicDataStructure.ListNode;

/*
 * 2016.7.5
 * 方法1，正经方法，按照题目的要求，插入排序。这里采用的是移动指针的方式。当然也可以创建一个新的链表。
 * 方法2，猥琐方法，首先O（n）时间复杂度，将链表存储在LinkedList对象。然后，调用Collections工具类的sort方法，排序。
 *                  最后O（n）时间复杂度，写回原始链表。  9ms。这就不符合题目要求了，因为不是插入排序了。
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
