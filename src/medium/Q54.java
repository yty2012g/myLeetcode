package medium;

import java.util.*;
/*
 * 2016.5.14
 * 这道题是按照螺旋状输出矩阵。
 * 要点1：使用way作为控制方向，1向右，2向下，3向左，4向上。
 * 要点2：每次输出一条边以后就将对应边的数量-1
 * 要点3：终止条件为有一条边剩余数量为0
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
