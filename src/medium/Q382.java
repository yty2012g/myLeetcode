package medium;

import basicDataStructure.ListNode;

/*
 * 2016.8.11
 * 这里利用了蓄水池采样的算法。
 * 假设从一个不知道具体大小的链表取k个数，并且保证每个数字的概率一致，
 * 首先，链表先遍历k个数，从第k+1个数开始，计算一个随机数【0，i）,如果小于K的，那么将当前节点和计算的随机数位置的节点交换。
 * 然后一直计算到结束，应该是O(N)的时间复杂度，但是不需要额外的空间，并且保证每个数字被取到的概率一样。
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
