package medium;

import java.util.*;

/*
 * 2016.7.6
 * ����û������ǰ�ķ�����
 * ������õķ����������ģ�����ջ��ԭ����һ��flag��Ϊ��ǣ����flag��true��ʾ��ʼһ���µ��ַ�����flag��false��ʾ����һ���ַ�����
 * ���������ַ�������ǿ��ַ������flag��Ϊtrue��
 * ������ǿ��ַ������flag��true����������һ���ַ�����ѹ��ջ�С�
 * ���flag��false���򵯳�ջ�����ַ��������ַ����룬��ѹ��ջ�С�
 * Ȼ�󣬽�ջ�е�Ԫ�����ε�������Ȼ��������Ľ����
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
