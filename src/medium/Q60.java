package medium;

import java.util.*;

public class Q60 {
	public String getPermutation(int n, int k) {
		String res = "";
		int times = 1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			times = times * i;
			list.add(i);
		}
		k = k % times;
		times = times / n;
		for (int i = 0; i < n-1; i++) {
			int num = (k + 1) / times;
			res = res + list.get(num - 1);
			list.remove(num - 1);
			times = times / (n - 1 - i);
			k = k % times;
		}
		res=res+list.get(0);
		return res;
	}
}
