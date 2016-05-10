package easy;

import java.util.HashMap;
/*
 * 2016.5.3
 * ����ʹ��һ��hashmap���洢�ַ���Ӧ�����֡�
 * ���ж��ַ����Ĺ����У�������ֵ�iλ������С�ڵ�i+1λ�����֣�����Ӧ���ǳ�����4����9����������ô�����ȥС����ͬʱ�����������ַ���
 */
public class Q13 {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('X', 10);
		map.put('C', 100);
		map.put('M', 1000);
		map.put('V', 5);
		map.put('L', 50);
		map.put('D', 500);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				int cur = map.get(s.charAt(i));
				int next = map.get(s.charAt(i + 1));
				if (next > cur) {
					res = res + next - cur;
					i++;
				} else {
					res = res + cur;
				}
			} else {
				int cur = map.get(s.charAt(i));
				res = res + cur;
			}
		}
		return res;
	}
}
