package medium;

import java.util.Arrays;

/*
 * 2016.9.1
 * 这个题目只是求是否出现三元组。。要求o1的空间复杂度，也算是满足了，因为标记长度的数组只要达到3就算是出现了三元组。
 * 所以长度子数组的长度是固定的，就是4.因此也算是O1的空间复杂度了。
 * 这里利用的是最长递增子序列的解决方法，首先使用一个len数组，len[i]表示，长度为i的递增子序列的最后一位最小可以是多少。
 * 然后，每次利用arrays.binarySearch可以找到一个放置的位置。
 * 3ms，还是略慢。
 */
public class Q334 {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int[] len = new int[nums.length];
		len[0] = nums[0];
		int l = 1;
		for (int i = 1; i < nums.length; i++) {
			int pos = Arrays.binarySearch(nums, 0, l, nums[i]);
			if (pos < 0) {
				pos = -1 * (pos + 1);
				if (pos == l)
					l++;
				nums[pos] = nums[i];
			}
			if (l > 2)
				return true;
		}
		return false;
	}
}
