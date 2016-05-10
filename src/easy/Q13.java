package easy;

import java.util.HashMap;
/*
 * 2016.5.3
 * 这里使用一个hashmap来存储字符对应的数字。
 * 在判断字符串的过程中，如果出现第i位的数字小于第i+1位的数字，表明应该是出现了4或者9的情况，则用大数减去小数，同时跳过大数的字符。
 */
public class Q13 {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('X', 10);
		map.put('C', 100);
		map.put('M', 1000);
		map.put('V', 5);
		map.put('L', 50);
		map.put('D', 500);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				int cur = map.get(s.charAt(i));
				int next = map.get(s.charAt(i + 1));
				if (next > cur) {
					res = res + next - cur;
					i++;
				} else {
					res = res + cur;
				}
			} else {
				int cur = map.get(s.charAt(i));
				res = res + cur;
			}
		}
		return res;
	}
}
