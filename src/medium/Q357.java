package medium;

/*
 * 2016.8.19
 * ��������������ϵ�ԭ��
 * ���ȣ����ֻ��10������ͬ�����֣�����n����10�Ժ��n����10û������
 * �ڶ���n����0ʱ��ֻ����0��һ�����֡�
 * ��󣬳��˵�һλ�ǲ���ѡ��0�����ֻ��9��ѡ��������λ��ѡ��Ϊ9-i+1�֡�Ȼ���ټ��ϵ�һλ��0�������Ҳ���ǵݹ����n-1�������
 */
public class Q357 {
	public int countNumbersWithUniqueDigits(int n) {
		if (n > 10)
			return countNumbersWithUniqueDigits(10);
		if (n == 0)
			return 1;
		int temp = 9;
		for (int i = 1; i < n; i++) {
			temp = temp * (9 - i + 1);
		}
		return temp + countNumbersWithUniqueDigits(n - 1);
	}
}
