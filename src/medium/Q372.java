package medium;

/*
 * 2016.8.16
 * 三种方法。
 * 第一种，基于二分和数组的方法。实现一个高精度除法的方法，每次将数组代表的数字除以2，然后利用二分来实现快速幂。6xxms
 * 第二种，基于二分和bigInteger的方法，如果不使用bigInteger的modPow方法，和上面一样，只不过高精度除法已经有实现了。4xxms/1xxms
 * 第三种，大神级方法。首先幂次方对1337去模，最多只会有1337情况，那么一定会出现，每隔一个循环周期出现一次相同的余数。
 *        然后，计算循环周期，从最初的余数开始，每次乘以a在取模，一旦和第一个相同，则可以得出循环周期。
 *        再然后，对数组表示的数字对循环周期取模，得到余数后，再从刚才的余数表中找到对应的位置。即可得到最终结果。 2ms
 */
public class Q372 {
	public int superPow2(int a, int[] b) {
		if (a == 1)
			return 1;
		int l = b.length, m = a, i, v = 0;
		int[] p = new int[1337];
		int mod = a % 1337;
		p[0] = mod;
		for (i = 1; i < 1337; i++) {
			m = (int) (((long) m * a) % 1337);
			if (m != mod)
				p[i] = m;
			else
				break;
		}
		for (int j = 0; j < l; j++) {
			v = ((v * 10) + b[j]) % i;
		}
		return p[v - 1];
	}

	java.math.BigInteger two = new java.math.BigInteger("2");

	public int superPow(int a, int[] b) {
		String s = "";
		for (int i = 0; i < b.length; i++) {
			s += b[i];
		}
		java.math.BigInteger bi = new java.math.BigInteger(s);
		java.math.BigInteger ai = java.math.BigInteger.valueOf(a);
		return ai.modPow(bi, new java.math.BigInteger("1337")).intValue();

	}

	public int cal(int a, java.math.BigInteger bi) {
		if (bi.equals(java.math.BigInteger.ONE))
			return a % 1337;
		if (!bi.mod(two).equals(java.math.BigInteger.ONE)) {
			int temp = cal(a, bi.divide(two)) % 1337;
			return (temp * temp) % 1337;
		} else {
			int temp = cal(a, bi.subtract(java.math.BigInteger.ONE).divide(two)) % 1337;
			return ((temp * temp) % 1337 * a) % 1337;
		}
	}

}
