package medium;

import java.util.*;

/*
 * 2016.7.19
 * 要点！！！要点！！！！要点！！！！！真的。所有类的比较请使用equals方法~~~~
 * 其他很容易。。类似dp的方法。。
 * 如果当前num值等于dp[i-1]上限+1，所以dp[i]的范围就是比dp[i-1]多1.
 */
public class Q228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums.length == 0)
			return res;
		if (nums.length == 1) {
			res.add(nums[0] + "");
			return res;
		}
		ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(nums[0]);
		first.add(nums[0]);
		dp.add(first);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == dp.get(i - 1).get(1) + 1) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(dp.get(i - 1).get(0));
				temp.add(dp.get(i - 1).get(1) + 1);
				dp.add(temp);
			} else {
				if (dp.get(i - 1).get(0).equals(dp.get(i - 1).get(1))) {
					res.add(dp.get(i - 1).get(1) + "");
				} else {
					res.add(dp.get(i - 1).get(0) + "->" + dp.get(i - 1).get(1));
				}
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[i]);
				temp.add(nums[i]);
				dp.add(temp);
			}
			if (i == nums.length - 1) {
				if (dp.get(i).get(0).equals(dp.get(i).get(1))) {
					res.add(dp.get(i).get(1) + "");
				} else {
					res.add(dp.get(i).get(0) + "->" + dp.get(i).get(1));
				}
			}
		}
		return res;
	}
}
