package easy;

import java.util.*;

/*
 * 2016.7.7
 * 两种方法，第一种方法很容易想到，利用Hashmap,只要统计的次数超过一半，直接返回。
 * 第二种方法位操作。对所有数字的每一个二进制位进行统计，因为majority number总是存在的（题目假设）
 * 如果majority number第i位为0，那么这一位0出现的次数超过1半，1出现的次数小于一半。同理1也是一样的。
 */
public class Q169 {
	public int majorityElement(int[] nums) {
		int[] bitnum = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				bitnum[i] += (nums[j] >> i) & 1;
			}
			res |= ((bitnum[i] > nums.length / 2) ? 1 : 0) << i;
		}
		return res;
	}

	public int majorityElement2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
			if (map.get(nums[i]) > nums.length / 2)
				return nums[i];
		}
		return 0;
	}
}
