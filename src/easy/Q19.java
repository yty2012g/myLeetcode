package easy;

import java.util.HashMap;

import basicDataStructure.ListNode;

/*
 * 2016.5.4
 * �����нڵ㶼�ŵ�һ��HashMap���棬key����ţ�value�ǽڵ㡣
 * ����n���ҵ���Ӧ����ţ��ж�ǰ���Ƿ���ڣ������ڣ����ǰһ���ڵ��nextָ���һ���ڵ㡣
 * ���ǰһ���ڵ㲻���ڣ���˵����ͷ�ڵ㣬��ôheadֱ��ָ���һ���ڵ㼴��
 * �����һ���ڵ㲻���ڣ�˵�������һ���ڵ㣬��ôǰһ���ڵ��nextָ��null���ɡ�
 */
public class Q19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		int max = 0;
		ListNode copy = head;
		while (copy != null) {
			max++;
			map.put(max, copy);
			copy = copy.next;
		}
		int before = max - n;
		int after = max - n + 2;
		if (before > 0 && after <= max) {
			map.get(before).next = map.get(after);
		} else if (before == 0) {
			head = map.get(after);
		} else {
			map.get(before).next = null;
		}
		return head;
	}
}
