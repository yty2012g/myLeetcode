package easy;

/*
 * 2016.7.8
 * ���Ƚ�����ת���ɶ������ַ������Ӷ������ַ��������һλ��ʼ���ơ�
 * ע�⣺�����ƣ�<<���ͼӺ�(+)��һ���ǣ�����Ӻţ��������ơ���������������ټӵĻ�����Ҫ�������š�
 */
public class Q190 {
	public int reverseBits(int n) {
		String bin = Integer.toBinaryString(n);
		int res = 0;
		int count = 0;
		for (int i = bin.length() - 1; count != 32; i--, count++) {
			if (i >= 0) {
				res = (res << 1) + (bin.charAt(i) - '0');
			} else {
				res = res << 1;
			}
		}
		return res;
	}
}
