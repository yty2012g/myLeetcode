package medium;

import java.util.*;

/*
 * 2016.7.14
 * 这道题的话，是考察位运算的。
 * 首先，使用一个list来记录目前还没有出现过0的位。
 * 如果，每一个范围的数字都要统计每一位的话，TLE
 * 然后，list的第一个数字代表目前还没有出现过0的最低位。
 * 所以想法是这样的，如果加上一个数x，能让这一位变成0，并且加完后依然在范围内，那么中间的所有数字都不用判断了。
 * 所以对于i，假设list的第一位是n,先将i>>n,再将,i<<n，然后加上1<<n，如果还在范围内，那么这一位肯定会出现0。
 * 所以每次跳过很多数字，时间才能满足。
 */
public class Q201 {
	public int rangeBitwiseAnd(int m, int n) {
		int length = Integer.toBinaryString(m).length();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < length; i++) {
			list.add(i);
		}
		for (int i = m; i <= n && i >= 0;) {
			for (int j = 0; j < list.size(); j++) {
				if (((i >> list.get(j)) & 1) == 0) {
					list.remove(j);
					j--;
				}
			}
			if (list.size() == 0)
				return 0;
			i = i >> list.get(0);
			i = i << list.get(0);
			i = i + (1 << list.get(0));
		}
		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			res |= 1 << list.get(i);
		}
		return res;
	}

	public int rangeBitwiseAnd2(int m, int n) {
		int res = 0;
		boolean flag = true;
		int length = Integer.toBinaryString(m).length();
		for (int i = 0; i <= length; i++) {
			for (int j = m; j <= n; j++) {
				if (((j >> i) & 1) == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res |= 1 << i;
			} else {
				res |= 0 << i;
			}
			flag = true;
		}
		return res;
	}
}
