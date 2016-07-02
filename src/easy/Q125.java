package easy;

/*
 * 2016.7.2
 * check方法的作用是检查一个字符是否是数字或者字母。
 * 使用start和end两个游标，每判断一次游标就变化一次，如果start指向的字符是非法的，则start右移一次，如果end指向非法，则end左移
 * 终止的标准是start>=end，所以即使是空字符串，也会判断为true；
 * 如果两个合法的字符不想等，则返回false；
 */
public class Q125 {
	public boolean isPalindrome(String s) {
		String temp = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!check(temp.charAt(start))) {
				start++;
				continue;
			}
			if (!check(temp.charAt(end))) {
				end--;
				continue;
			}
			if (temp.charAt(start) != temp.charAt(end))
				return false;
			else {
				start++;
				end--;
			}
		}
		return true;
	}

	public boolean check(char i) {
		if ((i <= 'z' && i >= 'a') || (i >= '0' && i <= '9'))
			return true;
		return false;
	}
}
