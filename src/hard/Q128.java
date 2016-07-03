package hard;

import java.util.*;
import java.util.Map.Entry;

/*
 * 2016.7.2 27ms
 * 这里没有用union-find的方法，直接用的java提供的treeSet类，由于treeSet使用红黑树来记录元素，因此默认是有序的。
 * 所以将每一个元素插入TreeSet中，然后遍历一遍，就可以得到最长的连续序列。
 * 
 * 下午14点48分更新：
 * 用了Arrays工具类的sort方法，直接变成5ms了。。
 * 好像是用了归并排序。。这样就超过了95%的答案，如果用union-find方法。。真的有用么？
 */
public class Q128 {
	public int longestConsecutive1(int[] nums) {
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			treeset.add(nums[i]);
		}
		Iterator<Integer> iter = treeset.iterator();
		boolean flag = false;
		int max = 1;
		int temp = 0;
		int old = 0;
		System.out.println(treeset);
		while (iter.hasNext()) {
			if (!flag) {
				flag = true;
				old = iter.next();
				temp = 1;
				continue;
			}
			int num = iter.next();
			if (num == old + 1) {
				old = num;
				temp++;
			} else {
				max = Math.max(temp, max);
				old = num;
				temp = 1;
			}
		}
		max = Math.max(max, temp);
		return max;
	}

	public int longestConsecutive2(int[] nums) {
		Arrays.sort(nums);
		boolean flag = false;
		int max = 1;
		int temp = 0;
		int old = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!flag) {
				flag = true;
				old = nums[i];
				temp = 1;
				continue;
			}
			if (nums[i] == old + 1 || nums[i] == old) {
				if (nums[i] == old)
					continue;
				old = nums[i];
				temp++;
			} else {
				max = Math.max(max, temp);
				old = nums[i];
				temp = 1;
			}
		}
		max = Math.max(max, temp);
		return max;
	}
}
