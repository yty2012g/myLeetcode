package medium;

/*
 * 2016.5.16
 * ÿһ�ж���һ���������У�ͬʱ��һ�е����ֵС����һ�е���Сֵ�����ÿһ��Ҳ���ǵ������С�
 * �����Ͻǿ�ʼ���㣬curM��curN��¼��ǰ�Ƚ�Ԫ�ص��к��С����target���ڸ�Ԫ�أ�����true
 * ������ڸ�Ԫ�أ��͵���һ�бȽϣ����С�ڣ��͵�ǰһ�����Ƚϡ�
 * ��������±궼û���ҵ�������false��
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
