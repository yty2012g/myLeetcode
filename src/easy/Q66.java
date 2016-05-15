package easy;

import java.util.*;
/*
 * 2016.5.15
 * ���Ǽ򵥵���ӣ�ʹ��jin��¼��λ�����Ϊ�˷�ֹ���һλ�����ѡ����stack��¼��1���ÿһλ��
 * ע�������������ֽ�λ��Ҫ����λ�ӵ���һλ��
 */
public class Q66 {
	public int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<Integer>();
		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		int jin = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + jin >= 10) {
				digits[i] = digits[i] + jin - 10;
				jin = 1;
				stack.push(digits[i]);
			} else {
				digits[i] = digits[i] + jin;
				jin = 0;
				stack.push(digits[i]);
			}
		}
		if (jin == 1)
			stack.push(1);
		int[] res = new int[stack.size()];
		int count = 0;
		while (!stack.empty()) {
			res[count] = stack.pop();
			count++;
		}
		return res;
	}
}
