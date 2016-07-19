package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.19
 * 删除单链表的一个节点，非最后一个节点。直接将该节点的next节点的数据和next指针都拷贝过来即可。
 */
public class Q237 {
	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
