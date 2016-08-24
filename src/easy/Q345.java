package easy;

import java.util.*;

/*
 * 2016.8.24
 * 两种方法。
 * 方法1，使用两个指针small和big，分别指向字符串的头和尾，然后开始遍历，直到找到一个元音字母就停止。big和small遍历之前和之后都要检查small<big的条件。
 * 方法2，使用栈。遍历字符串，将元音字母依次压入栈中。然后再遍历一遍，将元音字母在依次弹栈，就实现了反转元音。
 * 方法1，7ms
 * 方法2，16ms
 * 因为方法2要遍历两次字符串。
 */
public class Q345 {
	public String reverseVowels(String s) {
		StringBuilder sb = new StringBuilder(s);
		int small = 0;
		int big = sb.length() - 1;
		while (small < big) {
			for (; small < big; small++) {
				char temp = sb.charAt(small);
				if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' || temp == 'A'
						|| temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
					break;
				}
			}
			if (small >= big)
				break;
			for (; big > small; big--) {
				char temp = sb.charAt(big);
				if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' || temp == 'A'
						|| temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
					break;
				}
			}
			if (small >= big)
				break;
			char temp = sb.charAt(small);
			sb.setCharAt(small, sb.charAt(big));
			sb.setCharAt(big, temp);
			small++;
			big--;
		}
		return sb.toString();
	}

	public String reverseVowels2(String s) {
		StringBuilder sb = new StringBuilder(s);
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0, l = sb.length(); i < l; i++) {
			char temp = sb.charAt(i);
			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' || temp == 'A' || temp == 'E'
					|| temp == 'I' || temp == 'O' || temp == 'U')
				stack.push(temp);
		}
		for (int i = 0, l = sb.length(); i < l; i++) {
			char temp = sb.charAt(i);
			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' || temp == 'A' || temp == 'E'
					|| temp == 'I' || temp == 'O' || temp == 'U')
				sb.setCharAt(i, stack.pop());
		}
		return sb.toString();
	}
}
