package medium;

/*
 * 2016.5.10
 * ���ɽ������res������matrix��ÿһ��Ԫ�أ���i�е�j�е�Ԫ����˳ʱ����ת90�Ⱥ󣬱���˵�j�е�len-1-i��
 * matrix[i][j] -> res[j][len-1-i]
 * ���ݹ�ʽ����res���ɡ�
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
