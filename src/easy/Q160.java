package easy;

import basicDataStructure.ListNode;

/*
 * 2016.7.6
 * �ܼ򵥵���Ŀ��
 * ���ȱ������������õ����Ⱥ����һ���ڵ㡣������һ���ڵ㲻��ȣ�˵��û���ཻ��
 * ����ཻ������£����ϳ��������ȱ���n���ڵ㣬n������������ĳ��ȵĲ�ֵ��Ȼ����������ͬʱ��������������ͬһ���ڵ�ʱ���ء�
 */
public class Q160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int numA = 0;
		int numB = 0;
		ListNode copyA = headA;
		ListNode copyB = headB;
		ListNode endA = headA;
		ListNode endB = headB;
		while (copyA != null) {
			numA++;
			if (copyA.next == null)
				endA = copyA;
			copyA = copyA.next;
		}
		while (copyB != null) {
			numB++;
			if (copyB.next == null)
				endB = copyB;
			copyB = copyB.next;
		}
		if (endA != endB)
			return null;
		copyA = headA;
		copyB = headB;
		if (numA > numB) {
			for (int i = 0; i < numA - numB; i++) {
				copyA = copyA.next;
			}
		} else if (numA < numB) {
			for (int i = 0; i < numB - numA; i++) {
				copyB = copyB.next;
			}
		}
		while (copyA != copyB) {
			copyA = copyA.next;
			copyB = copyB.next;
		}
		return copyA;
	}
}
