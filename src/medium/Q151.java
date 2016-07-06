package medium;

import java.util.*;

/*
 * 2016.7.6
 * 这里没有用以前的方法。
 * 这里采用的方法是这样的，利用栈的原理，用一个flag作为标记，如果flag是true表示开始一个新的字符串，flag是false表示接着一个字符串。
 * 遍历所有字符，如果是空字符，则把flag标为true；
 * 如果不是空字符，如果flag是true，则新生成一个字符串并压入栈中。
 * 如果flag是false，则弹出栈顶的字符串，把字符加入，再压入栈中。
 * 然后，将栈中的元素依次弹出，自然就是逆序的结果。
 */
public class Q151 {
	public String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				flag = true;
			else {
				if (flag) {
					String res = "";
					res += s.charAt(i);
					stack.push(res);
					flag = false;
				} else {
					String res = stack.pop();
					res += s.charAt(i);
					stack.push(res);
				}
			}
		}
		String res = "";
		while (!stack.empty()) {
			if (res == "")
				res += stack.pop();
			else
				res = res + " " + stack.pop();
		}
		return res;
	}
}
