package medium;

/*
 * 2016.7.26
 * ����ƺ��뷨�ܼ򵥡�
 * �����������[0..n]�е�n�����֡�
 * ʹ��res��¼������������������Ľ����
 * ʹ��flag��¼[0...n]��n+1�����ֵ��������
 * res^flag�������Ľ����
 * ��Ϊ�����Ǹ�û���ֵ�����ֻ������һ�Σ��������ֶ����������Σ�������Ϊ0��
 */
public class Q268 {
	public int missingNumber(int[] nums) {
		int res = 0;
		int flag = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
			flag = flag ^ (i + 1);
		}
		return res ^ flag;
	}
}
