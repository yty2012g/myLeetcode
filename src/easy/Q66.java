package easy;

import java.util.*;
/*
 * 2016.5.15
 * 就是简单的相加，使用jin记录进位情况，为了防止最后一位溢出，选择用stack记录加1后的每一位。
 * 注意就是如果最后出现进位，要将进位加到第一位。
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
