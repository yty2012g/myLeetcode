package medium;

/*
 * 2016.5.16
 * �����õĶ���ռ临�Ӷ�ΪO��m+n��
 * ʹ����������ֱ��¼���л��߸����Ƿ���ֹ�0��
 * Ȼ���ٱ�����������������л��߸��г��ֹ�0���򽫴�Ԫ�ر��0��
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
