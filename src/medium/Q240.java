package medium;

/*
 * 2016.7.22
 * 利用每一行是递增的，每一列也是递增的。
 * 初始位置为右上角。
 * 如果target大于当前值，则向下移动。
 * 如果target小于当前值，则向左移动。
 * 如果等于，返回true；
 * 如果在下标正常的前提下都不能找到，返回false；
 */
public class Q240 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		if (n == 0)
			return false;
		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			if (target > matrix[i][j]) {
				i++;
			} else if (target < matrix[i][j]) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}
}
