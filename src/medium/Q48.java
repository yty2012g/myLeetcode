package medium;

/*
 * 2016.5.10
 * 生成结果矩阵res，对于matrix的每一个元素，第i行第j列的元素在顺时针旋转90度后，变成了第j行第len-1-i列
 * matrix[i][j] -> res[j][len-1-i]
 * 根据公式更新res即可。
 */
public class Q48 {
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		int[][] res = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				res[j][len - 1 - i] = matrix[i][j];
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				matrix[i][j] = res[i][j];
			}
		}
	}
}
