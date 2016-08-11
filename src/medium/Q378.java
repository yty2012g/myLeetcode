package medium;

import java.util.*;

/*
 * 2016.8.11
 * ������С���ѵ����ݽṹ��Ҳ����priorityQueue�����ȼ����С�
 * Ҫ���k��������ȼ������m*m-k+1С������
 * ���ԣ�����һ������Ϊm*m-k+2��С���ѡ��������Ԫ�ء�
 * ��������ﵽm*m-k+1�����ȼ��뵱ǰԪ�أ����Ƴ��Ѷ�Ԫ�ء�
 * ����������Ԫ�غ󣬶Ѷ�Ԫ�ؼ�Ϊ����
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
