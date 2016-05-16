package medium;

/*
 * 2016.5.16
 * 这里用的额外空间复杂度为O（m+n）
 * 使用两个数组分别记录该行或者该列是否出现过0；
 * 然后再遍历整个矩阵，如果改行或者该列出现过0，则将次元素变成0；
 */
public class Q73 {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		boolean[] tm = new boolean[m];
		boolean[] tn = new boolean[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					tm[i] = true;
					tn[j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (tm[i] || tn[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
