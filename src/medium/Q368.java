package medium;

import java.util.*;

/*
 * 2016.8.17
 * 这个题目用了DP的思想。有点仿照最长递增子序列的做法，还是O(n^2)级别的，效果一般。
 * 首先对数组排序，这样，就形成了一个递增的序列，只要比较当前序列最大值是否能够整除，就可以得到整个序列。
 * 然后，n[i][]用来记录以第i个元素为结尾的序列，dp[i]代表以第i个元素为结尾的序列的长度。
 * 第一个元素dp为1，n也只包括当前元素。从第二个元素开始遍历。
 * 对于第i个元素，从[0]开始找，能被第i个元素整除的，序列最长的元素。下标记为pos，pos位置的序列长度记为len，然后len++
 * 然后，n[i][0...len-2]是从pos位置复制过来，然后n[i][len-1]是第i个元素。
 * 如果第i个元素之前没有能够整除的元素，那么直接len记为1，n[i][0]为当前元素即可。
 * 在遍历所有元素之前，使用l记录最长的那个序列的长度，p记录最长序列的位置。
 * 遍历完所有元素后，将n[p][0...l-1]添加到list中，即可。
 */
public class Q368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0)
			return res;
		int[][] n = new int[nums.length][nums.length];
		int[] dp = new int[nums.length];
		Arrays.sort(nums);
		int p = 0;
		int l = 1;
		dp[0] = 1;
		n[0][0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int len = 1;
			int pos = i;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[j] > len - 1) {
					pos = j;
					len = dp[i] + 1;
				}
			}
			if (pos == i) {
				n[i][0] = nums[i];
				dp[i] = 1;
			} else {
				for (int j = 0; j < len - 1; j++) {
					n[i][j] = n[pos][j];
				}
				n[i][len - 1] = nums[i];
				dp[i] = len;
			}
			if (dp[i] > l) {
				l = dp[i];
				p = i;
			}
		}
		for (int i = 0; i < l; i++) {
			res.add(n[p][i]);
		}
		return res;
	}
}
