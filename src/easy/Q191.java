package easy;

/*
 * 2016.7.8
 * ע�⣬����Ҫ��n�����޷������������Բ���ʹ����������(>>)����Ҫʹ���߼����ƣ�>>>����
 * �����ܼ򵥣�ÿһ�κ�1�����������������1������һλҲ��1.count������n�߼����Ƽ��ɡ�
 * ��ֹ������n����0
 */
public class Q191 {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		return count;
	}
}
