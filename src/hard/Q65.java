package hard;

/*
 * 2016.5.15
 * 首先是将字符串首尾的空格去掉(这里还把符号位给去掉了)
 * 然后，遍历字符串，如果有不是0-9或者.或者e的，如果是符号位则不能在首尾同时前面一个字符必须为e
 * 定义一些规则
 * 规则1：如果出现了小数点和e，则小数点必须在e之前
 * 规则2：e不能单独出现
 * 规则3：小数点不能单独出现，或者小数点是第一位同时后面跟着e
 * 
 * 可以想象到的优化方案：一个有效的数字的结构为有符号整数+.+无符号整数+e+有符号整数来组成。
 * 因此只要看这三个部分是不是符合条件即可。
 */
public class Q65 {
	public boolean isNumber(String s) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				start = i;
				break;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				end = i;
				break;
			}
		}
		if (s.charAt(start) == '-' || s.charAt(start) == '+')
			start++;
		s = s.substring(start, end + 1);
		return check(s);
	}

	public boolean check(String s) {
		int dot = 0;
		int e = 0;
		int pd = -1;
		int pe = -1;
		for (int i = 0; i < s.length(); i++) {
			if (i != 0 && (s.charAt(i) == '+' || s.charAt(i) == '-') && s.charAt(i - 1) == 'e' && i != s.length() - 1)
				continue;
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9 || s.charAt(i) == '.' || s.charAt(i) == 'e') {
				if (s.charAt(i) == '.') {
					dot++;
					if (dot > 1)
						return false;
					pd = i;
				}
				if (s.charAt(i) == 'e') {
					e++;
					if (e > 1)
						return false;
					pe = i;
				}
			} else {
				return false;
			}
		}
		if (pd != -1 && pe != -1 && pd > pe)
			return false;
		if (pe == 0 || pe == s.length() - 1)
			return false;
		if (pd == 0 && (pe == pd + 1 || pd == s.length() - 1))
			return false;
		return true;
	}
}
