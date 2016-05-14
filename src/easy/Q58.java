package easy;

/*
 * 2016.5.14
 * 从最后往前遍历，从结尾开始第一个不是空格字符的字符开始计数，如果在字符串的遍历过程中出现空格，则返回计数值，如果没有也返回计数值，表明字符串只有一个单词
 */
public class Q58 {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0)
			return 0;
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && res == 0)
				continue;
			if (s.charAt(i) != ' ')
				res++;
			if (s.charAt(i) == ' ' && res != 0)
				return res;
		}
		return res;
	}
}
