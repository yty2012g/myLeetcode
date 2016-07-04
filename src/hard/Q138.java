package hard;

import basicDataStructure.RandomListNode;

/*
 * 2016.7.4
 * �������ÿһ���ڵ㶼����һ�����ָ�룬���ָ��ָ��null���������е�һ���ڵ㡣
 * ����ʹ��������ѭ����
 * ��һ��ѭ����ÿһ���ڵ������һ�������ڵ㡣��cur.next=copy
 * �ڶ���ѭ������㿽�����ָ�룬copy.random=cur.random.next
 * ������ѭ������ԭ��������
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
