package medium;

import basicDataStructure.ListNode;

/*
 * 2016.8.11
 * ������������ˮ�ز������㷨��
 * �����һ����֪�������С������ȡk���������ұ�֤ÿ�����ֵĸ���һ�£�
 * ���ȣ������ȱ���k�������ӵ�k+1������ʼ������һ���������0��i��,���С��K�ģ���ô����ǰ�ڵ�ͼ���������λ�õĽڵ㽻����
 * Ȼ��һֱ���㵽������Ӧ����O(N)��ʱ�临�Ӷȣ����ǲ���Ҫ����Ŀռ䣬���ұ�֤ÿ�����ֱ�ȡ���ĸ���һ����
 */
public class Q382 {
	public class Solution {
		ListNode head;

		/**
		 * @param head
		 *            The linked list's head. Note that the head is guanranteed
		 *            to be not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			this.head = head;
		}

		/** Returns a random node's value. */
		public int getRandom() {
			ListNode copy = head.next;
			int count = 2;
			while (copy != null) {
				java.util.Random rand = new java.util.Random();
				if (rand.nextInt(count) == 0) {
					int temp = head.val;
					head.val = copy.val;
					copy.val = temp;
				}
				copy = copy.next;
				count++;
			}
			return head.val;
		}
	}
}
