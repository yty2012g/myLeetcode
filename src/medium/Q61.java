package medium;

import java.util.*;
import basicDataStructure.*;

/*
 * 2016.5.15
 * ���Ҫ����������k��Ԫ���Ƶ�ǰ�棬�ȼ��ڽ�ǰ�棨num-k����Ԫ���Ƶ���β��
 * ���Ե�һ�������õ���Ԫ�ص�����num�ͽ�βԪ��end
 * Ȼ�����ÿ�ν�ͷԪ�طŵ���βԪ�أ�����µĽ�βԪ�ء�ע��ŵ���βԪ�ص�ʱ����Ҫ��nextָ��ָ��null����������ѭ����������⡣
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
