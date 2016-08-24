package easy;

/*
 * 2016.8.24
 * 两种方法，第一种就是先转换成char[]，然后操作。
 * 第二种，使用stringbuilder，然后便利stringbuilder，首尾互换。
 * 我发现，如果不改变string的长度，很多时候，还是char[]效率更高。
 */
public class Q344 {
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		char[] sc = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i++) {
			sb.append(sc[i]);
		}
		return sb.toString();
	}

	public String reverseString2(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0, l = s.length(); i < l / 2; i++) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(l - 1 - i));
			sb.setCharAt(l - 1 - i, temp);
		}
		return sb.toString();
	}
}
