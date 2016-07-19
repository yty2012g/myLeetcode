package medium;

import java.util.*;

/*
 * 2016.7.19
 * ֻ�����Ǹ������ͼӼ��˳��������㡣
 * Ҫ��1��ÿ�ζ�ȡ������������Ҫ�Ȱ�temp����ջ�С�
 * Ҫ��2��������s��temp�洢�����һ����������Ҫ����ջ�С�
 * Ҫ��3������ջ��ʱ����󻹻�ʣ�µ�һ�����֣�Ҫ�ڽ���м���������֡�
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
