package easy;

import java.util.*;

/*
 * 2016.7.14
 * ʹ��һ��hashmap������¼s�е��ַ���t�е��ַ��Ķ�Ӧ��ϵ��
 * ʹ��һ��hashset��¼�Ѿ���Ӧ����t�г��ֵ��ַ���
 * ���s�е��ַ��Ѿ�������hashmap�У�����Ӧt���ַ�����hashmap�ж�Ӧ���ַ����򷵻�false��
 * ���t�е�ͬһ���ַ���Ӧ��s�����ֲ�ͬ���ַ�������false��
 */
public class Q205 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() == 0)
			return true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashSet<Character> set = new HashSet<Character>();
		map.put(s.charAt(0), t.charAt(0));
		set.add(t.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			} else {
				if (set.contains(t.charAt(i)))
					return false;
				map.put(s.charAt(i), t.charAt(i));
				set.add(t.charAt(i));
			}
		}
		return true;
	}
}
