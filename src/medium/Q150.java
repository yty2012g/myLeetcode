package medium;

import java.util.*;

/*
 * 2016.7.6
 * 真是太坑爹了，不知道为什么Leetcode不能识别“/”，所以用的是String类的contains方法。
 * 基本就是栈的操作。只要是数字就入栈，遇到操作符，弹出两个数字，运算，再放回栈。
 * 最后栈中只剩下结果。
 *
 */
public class Q150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		String s = "+-*/";
		for (int i = 0; i < tokens.length; i++) {
			if (!s.contains(tokens[i])) {
				int number = Integer.parseInt(tokens[i]);
				stack.push(number);
			} else {
				int res = 0;
				int b = stack.pop();
				int a = stack.pop();
				switch (tokens[i]) {
				case "+":
					res = b + a;
					break;
				case "-":
					res = a - b;
					break;
				case "*":
					res = a * b;
					break;
				case "/":
					res = a / b;
					break;
				}
				stack.push(res);
			}
		}
		return stack.peek();
	}
}
