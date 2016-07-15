package medium;

import java.util.*;

/*
 * 2016.7.15
 * 建立一个小根堆。并且维护小根堆的容量为k。
 * 如果小根堆的容量小于k，则直接加入新元素即可。
 * 否则，如果当前元素小于小根堆的堆顶，不操作。大于堆顶，则先移除堆顶，然后加入当前元素。保持堆的容量为k。
 */
public class Q215 {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			if (pq.size() < k) {
				pq.add(nums[i]);
			} else {
				if (nums[i] > pq.peek()) {
					pq.remove(pq.peek());
					pq.add(nums[i]);
				}
			}
		}
		return pq.peek();
	}
}
