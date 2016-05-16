package medium;

import java.util.*;

/*
 * 2016.5.16
 * 如果num数组有n位，则有0到2^n-1中组合。
 * 对于每一种组合对应的是当前数字中，用二进制表示，所有1对应的位数的数字组成的组合
 * 因此，gen是根据一个数字，先求得二进制表达，找到所有1的位数，将对应的数字添加到结果即可。
 */
public class Q78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
			res.add(gen(nums, i));
		}
		return res;
	}

	public ArrayList<Integer> gen(int[] nums, int num) {
		String n = Integer.toBinaryString(num);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = n.length() - 1; i >= 0; i--) {
			if (n.charAt(i) == '1')
				res.add(nums[n.length() - 1 - i]);
		}
		return res;
	}
}
