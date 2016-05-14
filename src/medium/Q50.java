package medium;

/*
 * 2016.5.14
 * �������������˶�̬�滮��ԭ��
 * ���Ƚ�nת����2���ơ�
 * �ӵ�λ���λ���㣬���֪��n����n*n�Ϳ���֪�������֪��n^2 ��n^4�Ϳ���֪������˸��ݶ�Ӧ�Ķ����ƣ����������ɡ�
 * ÿһλ�����ƶ�����ǰһλƽ����á�
 * ���nΪ���������ȼ���n�ľ���ֵ������ٶԽ��ȡ�������ɡ�
 * ��֦�Ĳ��־������x��1����0��ֱ�ӷ���1����0�����ˡ�
 */
public class Q50 {
	public double myPow(double x, int n) {
		if (x == 1d || x == 0d)
			return x;
		String bin = Integer.toBinaryString(Math.abs(n));
		double res = 1;
		double temp = x;
		if (bin.charAt(bin.length() - 1) == '1')
			res = res * temp;
		for (int i = bin.length() - 2; i >= 0; i--) {
			temp = temp * temp;
			if (bin.charAt(i) == '1')
				res = res * temp;
		}
		if (n < 0)
			return 1 / res;
		return res;
	}
}
