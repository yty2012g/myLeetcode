package medium;

import java.util.*;

/*
 * 2016.7.19
 * 只包含非负整数和加减乘除四则运算。
 * 要点1，每次读取到操作符，都要先把temp放入栈中。
 * 要点2，解析完s后，temp存储了最后一个操作数，要放入栈中。
 * 要点3，解析栈的时候，最后还会剩下第一个数字，要在结果中加上这个数字。
 */
public class Q227 {
	public int calculate(String s) {
		Stack<String> stack = new Stack<String>();
		int temp = 0;
		int flag = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
				temp = temp * 10 + s.charAt(i) - '0';
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				stack.push(temp + "");
				temp = 0;
				if (flag != 0) {
					int b = Integer.parseInt(stack.pop());
					int a = Integer.parseInt(stack.pop());
					int r = flag == 1 ? a * b : a / b;
					stack.push(r + "");
				}
				stack.push(s.charAt(i) + "");
				flag = 0;
			} else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				stack.push(temp + "");
				temp = 0;
				if (flag != 0) {
					int b = Integer.parseInt(stack.pop());
					int a = Integer.parseInt(stack.pop());
					int r = flag == 1 ? a * b : a / b;
					stack.push(r + "");
				}
				flag = s.charAt(i) == '*' ? 1 : 2;
			}
		}
		stack.push(temp + "");
		if (flag != 0) {
			int b = Integer.parseInt(stack.pop());
			int a = Integer.parseInt(stack.pop());
			int r = flag == 1 ? a * b : a / b;
			stack.push(r + "");
		}
		int last = 0;
		int res = 0;
		while (!stack.empty()) {
			String t = stack.pop();
			if (t.equals("+")) {
				res = res + last;
				last = 0;
			} else if (t.equals("-")) {
				res = res - last;
				last = 0;
			} else {
				last = Integer.parseInt(t);
			}
		}
		res = res + last;
		return res;
	}
}
