package easy;

import java.util.Stack;

/*
 * 2016.5.2
 * 使用了一个栈来保存每一位，然后出栈的时候，按照顺序乘以位数即可，如第二位就乘以10，第三位乘以100，位数使用basic表示。
 * 注意！！！！int类型的溢出问题，也就是一个int，反过来不一定在int表示的范围内。
 * 首先检查，超过10位的一定没有结果。
 * 其次，每次出栈，乘以位数后，最高位一定是刚出栈的数字，如果出现溢出，则不满足此条件。
 */
public class Q7 {
	public int reverse(int x) {
		if (x == 0)
			return 0;
		int absX = Math.abs(x);
		if (!check(absX))
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		while (absX != 0) {
			s.push(absX % 10);
			absX = absX / 10;
		}
		int res = 0;
		int base = 1;
		while (!s.empty()) {
			int temp = s.pop();
			res = res + temp * base;
			if (res / base != temp)
				return 0;
			base = base * 10;
		}
		res = res * (x / Math.abs(x));
		return res;
	}

	public boolean check(int x) {
		Integer test = x;
		String s = test.toString();
		if (s.length() > 10)
			return false;
		return true;
	}
}
