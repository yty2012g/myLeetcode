package hard;

/*
 * 2016.5.15
 * �����ǽ��ַ�����β�Ŀո�ȥ��(���ﻹ�ѷ���λ��ȥ����)
 * Ȼ�󣬱����ַ���������в���0-9����.����e�ģ�����Ƿ���λ��������βͬʱǰ��һ���ַ�����Ϊe
 * ����һЩ����
 * ����1�����������С�����e����С���������e֮ǰ
 * ����2��e���ܵ�������
 * ����3��С���㲻�ܵ������֣�����С�����ǵ�һλͬʱ�������e
 * 
 * �������󵽵��Ż�������һ����Ч�����ֵĽṹΪ�з�������+.+�޷�������+e+�з�����������ɡ�
 * ���ֻҪ�������������ǲ��Ƿ����������ɡ�
 */
public class Q65 {
	public boolean isNumber(String s) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				start = i;
				break;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				end = i;
				break;
			}
		}
		if (s.charAt(start) == '-' || s.charAt(start) == '+')
			start++;
		s = s.substring(start, end + 1);
		return check(s);
	}

	public boolean check(String s) {
		int dot = 0;
		int e = 0;
		int pd = -1;
		int pe = -1;
		for (int i = 0; i < s.length(); i++) {
			if (i != 0 && (s.charAt(i) == '+' || s.charAt(i) == '-') && s.charAt(i - 1) == 'e' && i != s.length() - 1)
				continue;
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9 || s.charAt(i) == '.' || s.charAt(i) == 'e') {
				if (s.charAt(i) == '.') {
					dot++;
					if (dot > 1)
						return false;
					pd = i;
				}
				if (s.charAt(i) == 'e') {
					e++;
					if (e > 1)
						return false;
					pe = i;
				}
			} else {
				return false;
			}
		}
		if (pd != -1 && pe != -1 && pd > pe)
			return false;
		if (pe == 0 || pe == s.length() - 1)
			return false;
		if (pd == 0 && (pe == pd + 1 || pd == s.length() - 1))
			return false;
		return true;
	}
}
