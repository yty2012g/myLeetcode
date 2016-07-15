package medium;

import java.util.*;

/*
 * 2016.7.15
 * ����һ��С���ѡ�����ά��С���ѵ�����Ϊk��
 * ���С���ѵ�����С��k����ֱ�Ӽ�����Ԫ�ؼ��ɡ�
 * ���������ǰԪ��С��С���ѵĶѶ��������������ڶѶ��������Ƴ��Ѷ���Ȼ����뵱ǰԪ�ء����ֶѵ�����Ϊk��
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
