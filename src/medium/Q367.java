package medium;

/*
 * 2016.8.18
 * 题目只要求不能够使用库函数sqrt，可以自己写一个。
 * 根据牛顿法，可以得到一个效果很好的sqrt函数，比二分的效果要好很多。
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
