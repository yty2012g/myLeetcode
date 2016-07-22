package medium;

/*
 * 2016.7.22
 * ����ÿһ���ǵ����ģ�ÿһ��Ҳ�ǵ����ġ�
 * ��ʼλ��Ϊ���Ͻǡ�
 * ���target���ڵ�ǰֵ���������ƶ���
 * ���targetС�ڵ�ǰֵ���������ƶ���
 * ������ڣ�����true��
 * ������±�������ǰ���¶������ҵ�������false��
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
