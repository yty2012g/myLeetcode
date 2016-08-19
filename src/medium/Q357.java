package medium;

/*
 * 2016.8.19
 * 这里利用排列组合的原理。
 * 首先，最多只有10个不相同的数字，所以n大于10以后和n等于10没有区别。
 * 第二，n等于0时，只包含0这一个数字。
 * 最后，除了第一位是不能选择0，因此只有9种选法，其他位的选法为9-i+1种。然后再加上第一位是0的情况。也就是递归的求n-1的情况。
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
