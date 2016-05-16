package medium;

/*
 * 2016.5.16
 * 每一行都是一个递增序列，同时上一行的最大值小于这一行的最小值，因此每一列也都是递增序列。
 * 从右上角开始计算，curM和curN记录当前比较元素的行和列。如果target等于该元素，返回true
 * 如果大于该元素，就到下一行比较，如果小于，就到前一列来比较。
 * 如果超出下标都没有找到，返回false；
 */
public class Q74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		int curM = 0;
		int curN = n - 1;
		while (curM < m && curN >= 0) {
			if (target == matrix[curM][curN])
				return true;
			else if (target > matrix[curM][curN]) {
				curM++;
			} else {
				curN--;
			}
		}
		return false;
	}
}
