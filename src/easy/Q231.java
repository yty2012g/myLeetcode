package easy;

/*
 * 2016.7.19
 * 这个题目很简单，凡是2的幂次方一定是由1右移得到的。所以只要判断n是否等于32位正整数中的所有1右移得到的数字即可。
 * 注意0x80000000是最小的负数，是由1左移31得到的，不是2的幂次方。。
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
