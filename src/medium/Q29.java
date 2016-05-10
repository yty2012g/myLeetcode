package medium;

/*
 * 2016.5.7
 * 这道题的想法比较简单
 * 第一步，由于不能使用乘除和取模，首先通过左移的方式，找到第一个大于等于被除数的，除数的2的幂次方倍。
 * 有点绕口，简而言之就是找到一个2的幂次方倍，假如为x，除数乘以x大于等于被除数。同时x如果除以2，则前面的不等式就变成小于等于。
 * 第二步，只要剩余的数字大于等于除数则开始循环，只要当前的剩余数字大于x倍的除数，则剩余数字减去x倍的除数，如果小于，则x=x/2
 * 每次结果加上x即可。
 * 
 * 注意事项：1.int类型的取值范围，0x80000000~0x7fffffff，并且使用Math.abs()方法取绝对值时，Math.abs(0x80000000)是负的。
 * 因此使用绝对值函数时，需要先将源数字转换成long类型。
 * 2.初步的剪枝，除数为0，除数等于被除数，除数的绝对值大于被除数的绝对值。
 * 3.唯一的溢出情况，0x80000000除以-1，由于负数比正数多一个，会产生溢出，因此结果在计算时应使用long类型。
 */
public class Q29 {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return 0x7FFFFFFF;
		if (dividend == divisor)
			return 1;
		if (Math.abs((long) dividend) < Math.abs((long) divisor))
			return 0;
		int sign = 1;
		if (dividend < 0)
			sign = -1 * sign;
		if (divisor < 0)
			sign = -1 * sign;
		long bcs = Math.abs((long) dividend);
		long cs = Math.abs((long) divisor);
		long c = 1;
		while (cs < bcs) {
			cs = cs << 1;
			c = c << 1;
		}
		long res = 0;
		while (bcs >= Math.abs(divisor)) {
			while (bcs >= cs) {
				bcs -= cs;
				res += c;
			}
			cs = cs >> 1;
			c = c >> 1;
		}
		return res * sign > 0x7fffffff ? 0x7fffffff : (int) res * sign;
	}
}
