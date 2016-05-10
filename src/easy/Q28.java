package easy;
/*
 * 2016.5.7
 * 字符串匹配的问题，这里只用了最简单粗暴的方法。后续还会补充，kmp，有限状态机的方法。
 * 最简单的方法就是，一位一位查找，如果找到一位字符和needle头字符匹配，则从此字符开始依次和needle匹配。
 */
public class Q28 {
	public int strStr(String haystack, String needle) {
		int len = haystack.length();
		if (needle.length() > len)
			return -1;
		if (len == 0 || needle.length() == 0)
			return 0;

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				for (int j = 0; j < needle.length(); j++) {
					if (haystack.charAt(i + j) != needle.charAt(j))
						break;
					if (j == needle.length() - 1)
						return i;
				}
			}
		}
	}
}
