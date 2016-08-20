package hard;

import java.util.*;

/*
 * 2016.8.20
 * 这个题目给人的第一印象就是使用最长递增子序列（LIS）的基于二分搜索的方法来做。
 * 但是遇到一个障碍，对于两个信封（x1,y1）和(x2.y2)来说，如果在x1等于x2的情况下是应该把y大的放在前面还是后面。
 * 因为基于二分搜索的方法里面维护了一个长度数组len，len[i]表示长度为i的链的最后一个元素最小可以是多少。而上面的情况是无法比较的。
 * 因此，如果不使用基于二分的方法，时间大概在600ms左右，需要从0扫描到i，找到能够覆盖的，链最长的那个信封，然后长度加1.
 * 
 * ---------------------------------------------------------------------------
 * 但是，大神的方法就是不一样。首先还是需要排序，但是对于x1==x2的情况下，将y较大的放在前面。
 * 因此排序完以后，x就是有序的，但是y不是，就相当于转换成了，找到y中最长的递增子序列，由于x1==x2时，较大的y在前面。
 * 所以当y1>y2时，x1一定是小于x2的，因为排序的时候先比较较大的y，在比较较小的y。
 * 例如(1,1)(2,3)(2,4)(3,5)(3,4)这个序列：
 * 如果按照第一种排序方式得到的是，(1,1)(2,3)(2,4)(3,4)(3,5)，当比较第3个元素（2，4）的时候，要不要将长度为2的子序列的最后一个元素的值改成（2，4），这个是没有办法判断的。
 * 但是如果按照第一种排序方式得到是：(1,1)(2,4)(2,3)(3,5)(3,4)，可以很明显看到y值就是求最长递增子序列的问题。
 */
public class Q354 {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0 || envelopes[0].length != 2)
			return 0;
		Comparator<int[]> com = new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if (arg0[0] == arg1[0]) {
					return arg1[1] - arg0[1];
				} else {
					return arg0[0] - arg1[0];
				}
			}

		};
		Arrays.sort(envelopes, com);
		int[] dp = new int[envelopes.length];
		int len = 0;
		for (int i = 0; i < envelopes.length; i++) {
			int index = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
			if (index < 0) {
				index = -1 * (index + 1);
			}
			dp[index] = envelopes[i][1];
			if (index == len)
				len++;
		}
		return len;
	}

	public int shunxu(int[][] envelopes) {
		int m = envelopes.length;
		if (m == 0)
			return 0;
		Comparator<int[]> com = new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if (arg0[0] > arg1[0]) {
					return 1;
				} else if (arg0[0] < arg1[0]) {
					return -1;
				} else {
					if (arg0[1] > arg1[1])
						return 1;
					else if (arg0[1] < arg1[1])
						return -1;
					else
						return 0;
				}
			}

		};
		Arrays.sort(envelopes, com);
		int[] dp = new int[m];
		dp[0] = 1;
		int mm = 1;
		for (int i = 1; i < m; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (can(envelopes[j], envelopes[i])) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = max + 1;
			mm = Math.max(mm, dp[i]);
		}
		return mm;
	}

	public boolean can(int[] arg0, int[] arg1) {
		if (arg0[0] < arg1[0] && arg0[1] < arg1[1])
			return true;
		else
			return false;
	}
}
