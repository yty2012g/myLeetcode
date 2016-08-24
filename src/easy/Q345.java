package easy;

import java.util.*;

/*
 * 2016.8.24
 * ���ַ�����
 * ����1��ʹ������ָ��small��big���ֱ�ָ���ַ�����ͷ��β��Ȼ��ʼ������ֱ���ҵ�һ��Ԫ����ĸ��ֹͣ��big��small����֮ǰ��֮��Ҫ���small<big��������
 * ����2��ʹ��ջ�������ַ�������Ԫ����ĸ����ѹ��ջ�С�Ȼ���ٱ���һ�飬��Ԫ����ĸ�����ε�ջ����ʵ���˷�תԪ����
 * ����1��7ms
 * ����2��16ms
 * ��Ϊ����2Ҫ���������ַ�����
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
