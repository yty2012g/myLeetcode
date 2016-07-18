package easy;

import java.util.*;

/*
 * 2016.7.18
 * 这个好像也比较简单。就是使用一个hashTable，如果hashtable出现了当前遍历的数字，则返回true；否则返回false；
 */
public class Q217 {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
