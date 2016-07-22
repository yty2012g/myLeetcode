package medium;

import java.util.*;

/*
 * 2016.7.22
 * 分治法。太巧妙。
 * 首先是，所有数字异或，得到不同两个数字的异或结果，a^b，记为sum。
 * 然后，得到sum中第一个不为0的位。使用sum&-sum，因为负数是正数的补码。结果记为flag。对于这一位而言，a和b是不同的。必然是一个是1，一个是0
 * 所以根据这一位，可以将数组划分成两部分，一部分这一位为0，一部分这一位为1。然后就变成数组中其余数字出现2次，该数字出现1次。
 * 遍历数组，如果nums[i] & flag不为0，则加入异或结果，最终得到该为为1的那个数。
 * 另外一个数，就是sum^上一步的结果。
 */
public class Q260 {
	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum ^ nums[i];
		}
		int flag = sum & (-1 * sum);
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & flag) != 0) {
				a = a ^ nums[i];
			}
		}
		res[0] = a;
		res[1] = sum ^ a;
		return res;
	}
}
