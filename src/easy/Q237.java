package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.19
 * ɾ���������һ���ڵ㣬�����һ���ڵ㡣ֱ�ӽ��ýڵ��next�ڵ�����ݺ�nextָ�붼�����������ɡ�
 */
public class Q237 {
	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
