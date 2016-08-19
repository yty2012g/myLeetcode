package medium;

/*
 * 2016.8.18
 * ��ĿֻҪ���ܹ�ʹ�ÿ⺯��sqrt�������Լ�дһ����
 * ����ţ�ٷ������Եõ�һ��Ч���ܺõ�sqrt�������ȶ��ֵ�Ч��Ҫ�úܶࡣ
 */
public class Q367 {
	public double sqrt(int n) {
		double k = 1;
		while (Math.abs(k * k - n) > 1e-10) {
			k = 0.5 * (k + n / k);
		}
		return k;
	}

	public boolean isPerfectSquare(int num) {
		int sq = (int) sqrt(num);
		if (sq * sq == num)
			return true;
		else
			return false;
	}
}
