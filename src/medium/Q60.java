package medium;

import java.util.*;

/*
 * 2016.5.15
 * 在字典序是递增的情况下，取值范围从1到n！，将下标从0开始，方便取模，所以范围从0~n！-1
 * 使用一个链表记录还没有用过的数字。
 * 步骤如下：
 * 第一步，计算出n！，并得到（n-1）！记为times
 * 第二步，计算出当前k位于第几个(n-1)!，从0到n-1，使用除法，得到第几个，然后从链表取出对应位的数字，加入结果
 * 第三步，k范围缩小到（n-1）！，times缩小到（n-2）！，重复第2步。
 * 第四步，加上链表的最后一个数字。
 */
public class Q60 {
	public String getPermutation(int n, int k) {
		String res = "";
		int times = 1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			times = times * i;
			list.add(i);
		}
		k--;
		times = times / n;
		for (int i = 0; i < n - 1; i++) {
			int num = k / times;
			res = res + list.get(num);
			list.remove(num);
			k = k - num * times;
			times = times / (n - 1 - i);
		}
		res = res + list.get(0);
		return res;
	}
}
