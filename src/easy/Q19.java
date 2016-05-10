package easy;

import java.util.HashMap;

import basicDataStructure.ListNode;

/*
 * 2016.5.4
 * 把所有节点都放到一个HashMap里面，key是序号，value是节点。
 * 给定n，找到对应的序号，判断前后是否存在，都存在，则把前一个节点的next指向后一个节点。
 * 如果前一个节点不存在，则说明是头节点，那么head直接指向后一个节点即可
 * 如果后一个节点不存在，说明是最后一个节点，那么前一个节点的next指向null即可。
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
