package medium;

import java.util.*;
/*
 * 2016.5.14
 * ������ǰ�������״�������
 * Ҫ��1��ʹ��way��Ϊ���Ʒ���1���ң�2���£�3����4���ϡ�
 * Ҫ��2��ÿ�����һ�����Ժ�ͽ���Ӧ�ߵ�����-1
 * Ҫ��3����ֹ����Ϊ��һ����ʣ������Ϊ0
 */
public class Q54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0)
			return res;
		int n = matrix[0].length;
		int way = 1;
		int startX = 0;
		int startY = 0;
		while (m != 0 && n != 0) {
			switch (way) {
			case 1:
				for (int i = startY; i < startY + n; i++) {
					res.add(matrix[startX][i]);
				}
				m--;
				startX++;
				startY = startY + n - 1;
				way = 2;
				break;
			case 2:
				for (int i = startX; i < startX + m; i++) {
					res.add(matrix[i][startY]);
				}
				n--;
				startY--;
				startX = startX + m - 1;
				way = 3;
				break;
			case 3:
				for (int i = startY; i > startY - n; i--) {
					res.add(matrix[startX][i]);
				}
				m--;
				startX--;
				startY = startY - n + 1;
				way = 4;
				break;
			case 4:
				for (int i = startX; i > startX - m; i--) {
					res.add(matrix[i][startY]);
				}
				n--;
				startY++;
				startX = startX - m + 1;
				way = 1;
			}
		}
		return res;
	}
}
