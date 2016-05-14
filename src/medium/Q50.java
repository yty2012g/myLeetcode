package medium;

/*
 * 2016.5.14
 * 这道题就是利用了动态规划的原理。
 * 首先将n转换成2进制。
 * 从低位向高位计算，如果知道n，则n*n就可以知道，如果知道n^2 则n^4就可以知道，因此根据对应的二进制，计算结果即可。
 * 每一位二进制都是由前一位平方求得。
 * 如果n为负数，就先计算n的绝对值情况，再对结果取倒数即可。
 * 剪枝的部分就是如果x是1或者0，直接返回1或者0就行了。
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
