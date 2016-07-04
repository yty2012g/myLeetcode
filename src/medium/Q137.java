package medium;

import java.util.Arrays;

/*
 * 2016.7.4
 * 方法1：调用Arrays的方法进行排序，那么出现一次的那个数，和他两边的都不相同。此时即可得出。
 * 方法2：使用一个32位的整形数组，记录每一位出现的次数。只出现一次的那个数，对应的二进制位出现的次数一定是模3余1的，因此通过查找数组，就可以还原原始数字
 */
public class Q137 {
	public int singleNumber(int[] nums) {
		int[] bitnum = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; i++) {
				bitnum[i] += (nums[j] >> i) & 1;
			}
			res |= (bitnum[i] % 3) << i;
		}
		return res;
	}
}
