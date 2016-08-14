package easy;

/*
 * 2016.8.14
 * 最基本的二分搜索。
 * 要点1，循环条件，s<e，不是等于
 * 要点2，修改边界时要+1或者-1
 */
public class Q374 {
	int guess(int num) {
		return 0;
	}

	public int guessNumber(int n) {
		int s = 1;
		int e = n;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (guess(m) > 0) {
				s = m + 1;
			} else if (guess(m) == 0) {
				return m;
			} else {
				e = m - 1;
			}
		}
		return s;
	}
}
