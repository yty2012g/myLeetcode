package easy;

/*
 * 2016.8.9
 * ʹ��int�ܱ�ʾ������3���ݴη������������㡣
 * ��Ϊ�������ֻ����3���ݴη���Ϊ��������������������˵����3���ݴη���
 */
public class Q326 {
	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		return 1162261467 % n == 0;
	}
}
