package easy;

import java.util.*;

/*
 * 2016.7.14
 * 题目比较简单。有两种可能，第一种就是最终可以变成1，第二种就是一直再循环，并且不会等于1
 * 使用hashset记录已经出现的数字。
 * 如果处理后的数字出现过，则直接跳出循环。
 * 如果处理后的数字等于1，终止循环。返回1.
 */
public class Q202 {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			int nint = 0;
			while (n != 0) {
				nint = nint + (n % 10) * (n % 10);
				n = n / 10;
			}
			if (set.contains(nint))
				break;
			n = nint;
			set.add(nint);
		}
		return n == 1 ? true : false;
	}
}
