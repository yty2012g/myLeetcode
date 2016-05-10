package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/*
 * 2016.5.4
 * 额。。这个题目解决方案比较无脑，把4sum转换成3sum，然后3sum转换成2sum。
 */
public class Q18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		if (len < 4)
			return null;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len - 3; i++) {
			if (map.get(nums[i]) != null)
				continue;
			map.put(nums[i], i);
			ArrayList<ArrayList<Integer>> middle = threeSum(nums, i + 1, len - 1, target - nums[i]);
			if (middle.size() == 0)
				continue;
			Iterator<ArrayList<Integer>> iter = middle.iterator();
			while (iter.hasNext()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[i]);
				ArrayList<Integer> m = iter.next();
				temp.add(m.get(0));
				temp.add(m.get(1));
				temp.add(m.get(2));
				res.add(temp);
				temp = null;
			}
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] nums, int start, int end, int target) {
		int len = nums.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = start; i < len - 2; i++) {
			if (map.get(nums[i]) != null)
				continue;
			map.put(nums[i], i);
			ArrayList<ArrayList<Integer>> middle = twoSum(nums, i + 1, len - 1, target - nums[i]);
			if (middle.size() == 0)
				continue;
			Iterator<ArrayList<Integer>> iter = middle.iterator();
			while (iter.hasNext()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[i]);
				ArrayList<Integer> m = iter.next();
				temp.add(m.get(0));
				temp.add(m.get(1));
				res.add(temp);
				temp = null;
			}
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int start, int end, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (end - start + 1 < 2)
			return res;
		int head = start;
		int foot = end;
		while (head < foot) {
			if (nums[head] + nums[foot] == target) {
				if (map.get(nums[head]) == null) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[head]);
					temp.add(nums[foot]);
					map.put(nums[head], nums[foot]);
					head++;
					foot--;
					res.add(temp);
				} else {
					head++;
					foot--;
				}
			} else if (nums[head] + nums[foot] > target) {
				foot--;
			} else {
				head++;
			}
		}
		return res;
	}
}
