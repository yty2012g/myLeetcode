package medium;

import java.util.*;

/*
 * 2016.7.19
 * 摩尔投票法。投票出来的是出现次数最多的n个数字。
 * 对于本题而言，如果一个数字出现次数超过n/3次，那么最多只有两个数字。
 * 因此首先得到出现次数最多的两个数字，然后得到他们具体的出现次数即可。
 */
public class Q229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0)
			return res;
		int a = 0;
		int b = 0;
		int ta = -1;
		int tb = -1;
		for (int i = 0; i < nums.length; i++) {
			if (ta == -1 || tb == -1) {
				if (ta == -1) {
					ta = 1;
					a = nums[i];
				} else if (a == nums[i]) {
					ta++;
				} else {
					tb = 1;
					b = nums[i];
				}
				continue;
			}
			if (a == nums[i] || b == nums[i]) {
				ta = a == nums[i] ? ta + 1 : ta;
				tb = b == nums[i] ? tb + 1 : tb;
			} else if (ta == 0 || tb == 0) {
				if (ta == 0) {
					a = nums[i];
					ta = 1;
				} else {
					b = nums[i];
					tb = 1;
				}
			} else {
				ta--;
				tb--;
			}
		}
		ta = 0;
		tb = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a)
				ta++;
			else if (nums[i] == b)
				tb++;
		}
		if (ta > nums.length / 3)
			res.add(a);
		if (tb > nums.length / 3)
			res.add(b);
		return res;
	}
}
