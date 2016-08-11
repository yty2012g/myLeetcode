package medium;

import java.util.*;

/*
 * 2016.8.11
 * 利用了小根堆的数据结构，也就是priorityQueue，优先级队列。
 * 要求第k大的数，等价于求第m*m-k+1小的树。
 * 所以，构造一个容量为m*m-k+2的小根堆。依次添加元素。
 * 如果容量达到m*m-k+1，就先加入当前元素，再移除堆顶元素。
 * 遍历完所有元素后，堆顶元素即为所求。
 */
public class Q378 {
	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(m * m - k + 2);
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pq.size() < m * m - k + 1) {
					pq.add(matrix[j][i]);
				} else {
					pq.add(matrix[j][i]);
					pq.poll();
				}

			}
		}
		return pq.poll();
	}
}
