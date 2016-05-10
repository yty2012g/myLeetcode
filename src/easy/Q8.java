package easy;

import java.util.Stack;

/*
 * 2016.5.1
 * ���ⱸע�ǳ��࣡����
 * �����ǽ�һ���ַ���ת����int���͵�����
 * 1.�����޳��ַ���ǰ��Ŀ��ַ���������get������
 * 2.�����ַ����ĵ�һ��������+����-�ţ���ʾ������
 * 3.������ַ���������ַ������ַ���������ֹ������������boolean��ʾ��start��end��
 * 4.������ֳ������������������ޣ����������ޱ�ʾ��
 * 5.�������;ʹ��long���ͱ�ʾ��һ��Ҫ���м��ж��Ƿ�Խ�磬������ܳ���longҲԽ��������
 * 6.�м��ת������ʹ��һ��ջ���ɡ�
 */
public class Q8 {
	public int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		str = get(str);
		char[] sc = str.toCharArray();
		Stack<Integer> s = new Stack<Integer>();
		int flag = 0;
		boolean existNum = false;
		boolean start = true;
		boolean end = false;
		for (int i = 0; i < sc.length; i++) {
			if (flag == 0 && sc[i] == '-' && !existNum) {
				flag = -1;
				continue;
			}
			if (flag == 0 && sc[i] == '+' && !existNum) {
				flag = 1;
				continue;
			}
			if (sc[i] - '0' > 9 || sc[i] - '0' < 0)
				end = true;
			if (start && end)
				break;
			if (s.empty() && sc[i] - '0' == 0) {
				existNum = true;
				continue;
			}
			s.push(sc[i] - '0');
			existNum = true;
		}
		long base = 1;
		long res = 0;
		if (flag == 0)
			flag = 1;
		base = base * (long) flag;
		while (!s.empty()) {
			long temp = s.pop();
			res = res + temp * base;
			if (res > 2147483647) {
				res = 2147483647;
				break;
			}
			if (res < -2147483648) {
				res = -2147483648;
				break;
			}
			base *= 10;
		}

		return (int) res;
	}

	public String get(String s) {
		char[] sc = s.toCharArray();
		String res = "";
		boolean flag = true;
		for (int i = 0; i < sc.length; i++) {
			if (sc[i] == ' ' && flag)
				continue;
			flag = false;
			res = res + sc[i];
		}
		return res;
	}
}
