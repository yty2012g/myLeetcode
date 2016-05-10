package easy;

import java.util.Stack;

/*
 * 2016.5.1
 * 此题备注非常多！！！
 * 问题是将一个字符串转换成int类型的整数
 * 1.首先剔除字符串前面的空字符，这里用get方法。
 * 2.后续字符串的第一个可以是+或者-号，表示正负。
 * 3.后面的字符串如果出现非数字字符，则处理终止，这里用两个boolean表示，start和end。
 * 4.如果数字超过整数正负的上下限，则用上下限表示。
 * 5.如果在中途使用long类型表示，一定要在中间判断是否越界，否则可能出现long也越界的情况。
 * 6.中间的转换过程使用一个栈即可。
 */
public class Q8 {
	public int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		str = get(str);
		char[] sc = str.toCharArray();
		Stack<Integer> s = new Stack<Integer>();
		int flag = 0;
		boolean existNum = false;
		boolean start = true;
		boolean end = false;
		for (int i = 0; i < sc.length; i++) {
			if (flag == 0 && sc[i] == '-' && !existNum) {
				flag = -1;
				continue;
			}
			if (flag == 0 && sc[i] == '+' && !existNum) {
				flag = 1;
				continue;
			}
			if (sc[i] - '0' > 9 || sc[i] - '0' < 0)
				end = true;
			if (start && end)
				break;
			if (s.empty() && sc[i] - '0' == 0) {
				existNum = true;
				continue;
			}
			s.push(sc[i] - '0');
			existNum = true;
		}
		long base = 1;
		long res = 0;
		if (flag == 0)
			flag = 1;
		base = base * (long) flag;
		while (!s.empty()) {
			long temp = s.pop();
			res = res + temp * base;
			if (res > 2147483647) {
				res = 2147483647;
				break;
			}
			if (res < -2147483648) {
				res = -2147483648;
				break;
			}
			base *= 10;
		}

		return (int) res;
	}

	public String get(String s) {
		char[] sc = s.toCharArray();
		String res = "";
		boolean flag = true;
		for (int i = 0; i < sc.length; i++) {
			if (sc[i] == ' ' && flag)
				continue;
			flag = false;
			res = res + sc[i];
		}
		return res;
	}
}
