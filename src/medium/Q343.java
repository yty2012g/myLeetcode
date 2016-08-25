package medium;

/*
 * 2016.8.25
 * 最大的积是由一系列的3和2或者4构成的。
 * 7 3，3
 * 8 3，3，2
 * 9 3，3，3
 * 10 3，3，4
 * 11 3，3，3，2
 * 12 3，3，3，3
 * .。。。。
 * 所以就是如下公式
 * if (n % 3 == 0)
 * return (int) Math.pow(3, n / 3);
 * if (n % 3 == 1)
 * return (int) (Math.pow(3, n / 3 - 1) * 4);
 * return (int) (Math.pow(3, n / 3) * 2);
 */
public class Q343 {
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		if (n % 3 == 0)
			return (int) Math.pow(3, n / 3);
		if (n % 3 == 1)
			return (int) (Math.pow(3, n / 3 - 1) * 4);
		return (int) (Math.pow(3, n / 3) * 2);
	}
}
