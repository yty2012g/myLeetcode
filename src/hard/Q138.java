package hard;

import basicDataStructure.RandomListNode;

/*
 * 2016.7.4
 * 单链表的每一个节点都增加一个随机指针，这个指针指向null或者链表中的一个节点。
 * 这里使用了三个循环。
 * 第一个循环，每一个节点后增加一个拷贝节点。即cur.next=copy
 * 第二个循环，深层拷贝随机指针，copy.random=cur.random.next
 * 第三个循环，还原两条链表。
 */
public class Q138 {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode copy = new RandomListNode(cur.label);
			copy.next = cur.next;
			cur.next = copy;
			cur = copy.next;
		}
		cur = head;
		RandomListNode newhead = new RandomListNode(0);
		RandomListNode newcur = newhead;
		while (cur != null) {
			RandomListNode copy = cur.next;
			if (cur.random != null)
				copy.random = cur.random.next;
			cur = copy.next;
		}
		cur = head;
		while (cur != null) {
			newcur.next = cur.next;
			newcur = newcur.next;
			cur.next = newcur.next;
			cur = cur.next;
		}
		return newhead.next;
	}
}
