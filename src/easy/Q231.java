package easy;

/*
 * 2016.7.19
 * �����Ŀ�ܼ򵥣�����2���ݴη�һ������1���Ƶõ��ġ�����ֻҪ�ж�n�Ƿ����32λ�������е�����1���Ƶõ������ּ��ɡ�
 * ע��0x80000000����С�ĸ���������1����31�õ��ģ�����2���ݴη�����
 */
public class Q231 {
	public boolean isPowerOfTwo(int n) {
		for (int i = 0; i < 31; i++) {
			if (n == (1 << i))
				return true;
		}
		return false;
	}
}
