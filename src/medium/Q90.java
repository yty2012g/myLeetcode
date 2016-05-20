package medium;

import java.util.*;

/*
 * 2016.5.20
 * 这里没有用回溯，使用的是二进制的方法。
 * nums的每一个数字代表一位二进制，要么等于1，也就是加入这个数字，要么等于0，也就是不加入这个数字
 * 所以从0遍历到2^n-1.找到每一个数字对应的二进制，其中1代表的位数，表示使用这些数字，将这些数字加入结果即可。
 */
public class Q90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
			String temp = Integer.toBinaryString(i);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = temp.length() - 1; j >= 0; j--) {
				if (temp.charAt(j) == '1') {
					list.add(nums[temp.length() - 1 - j]);
				}
			}
			Collections.sort(list);
			hashset.add(list);
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Iterator iter = hashset.iterator();
		while (iter.hasNext()) {
			res.add((List<Integer>) iter.next());
		}
		return res;
	}

}
