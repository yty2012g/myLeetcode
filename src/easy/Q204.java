package easy;

import java.util.*;

/*
 * 2016.7.14
 * 这个就是判断质数的一般方法。
 * 从2开始，将2的所有倍数都剔除。
 * 然后找到下一个没有被剔除的数字，质数出现的次数加1。
 */
public class Q204 {
	public int countPrimes(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		byte[] num = new byte[n];
		for (int i = 1; i < n - 1; i++) {
			if (num[i] != 0)
				continue;
			count++;
			for (int j = i + i + 1; j < n; j = j + i + 1) {
				num[j] = 1;
			}
		}
		return count;
	}
}
