package medium;

import java.util.*;

/*
 * 2016.5.20
 * 使用回溯的方法，以ip地址中的.号为标记，每次最多取出3位数字，并且每一次取得数字如果不是0的话，开头不能为0
 * 如果已经取出的数字个数等于原字符串的长度，并且.号已经都标记了，则将结果记录。
 */
public class Q93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 4)
			return res;
		String prefix = "";
		c(res, s, 0, prefix, 0);
		return res;
	}

	public void c(List<String> res, String s, int num, String prefix, int dot) {
		if (num == s.length() && dot == 4) {
			res.add(prefix.substring(0, prefix.length() - 1));
			return;
		}
		if (s.length() - num > 3 * (3 - dot + 1) || s.length() - num < (3 - dot + 1))
			return;
		int start = 1;
		int end = s.length() - num >= 3 ? 3 : s.length() - num;
		for (int i = start; i <= end; i++) {
			String te = s.substring(num, num + i);
			if (te.charAt(0) == '0' && te.length() != 1)
				continue;
			int temp = Integer.parseInt(te);
			if (temp >= 0 && temp <= 255) {
				c(res, s, num + i, prefix + s.substring(num, num + i) + ".", dot + 1);
			}
		}
	}
}
