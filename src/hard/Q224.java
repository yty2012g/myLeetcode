package hard;

import java.util.*;

/*
 * 2016.7.18
 * 字符串相等要用equals方法。。。。。。。。
 * 基本就是用栈的结构。
 * 把操作符和数字还有括号放入栈中。
 * 如果到了右括号。则开始弹栈计算到左括号。
 * 然后最后整体弹栈计算即可。
 */
public class Q224 {
	public int calculate(String s) {
		Stack<String> stack = new Stack<String>();
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push("(");
			} else if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
				temp = temp * 10 + s.charAt(i) - '0';
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				stack.push(temp + "");
				stack.push(s.charAt(i) + "");
				temp = 0;
			} else if (s.charAt(i) == ')') {
				int middle = 0;
				int last = 0;
				stack.push(temp + "");
				temp = 0;
				while (!stack.peek().equals("(")) {
					if (stack.peek().equals("-") || stack.peek().equals("+")) {
						last = stack.pop().equals("-") ? last * -1 : last;
						middle += last;
					} else {
						last = Integer.parseInt(stack.pop());
					}
				}
				middle = middle + last;
				stack.pop();
				stack.push(middle + "");
			}
		}
		int res = 0;
		if (stack.empty() || stack.peek().equals("-") || stack.peek().equals("+"))
			stack.push(temp + "");
		int last = 0;
		while (!stack.empty()) {
			if (stack.peek().equals("-") || stack.peek().equals("+")) {
				last = stack.pop().equals("-") ? last * -1 : last;
				res += last;
			} else {
				last = Integer.parseInt(stack.pop());
			}
		}
		return res;
	}
}
