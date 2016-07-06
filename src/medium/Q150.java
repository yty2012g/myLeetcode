package medium;

import java.util.*;

/*
 * 2016.7.6
 * ����̫�ӵ��ˣ���֪��ΪʲôLeetcode����ʶ��/���������õ���String���contains������
 * ��������ջ�Ĳ�����ֻҪ�����־���ջ�������������������������֣����㣬�ٷŻ�ջ��
 * ���ջ��ֻʣ�½����
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
