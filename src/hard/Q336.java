package hard;

import java.util.*;

/*
 * 2016.8.30
 * ����һ���ַ������顣���Ƚ����е��ַ�������hashMap�С�
 * Ȼ�󣬱���ÿһ���ַ�����
 * ���ַ����ֳ������֡�a��b��
 * ���b�ǻ��ĵģ�����a�ķ�����hashmap�У���a�ķ�����ԭ�ַ��������ַ�����a�ķ����Ӧ���ַ�������ɻ����ַ�����
 * ���a�ǻ��ĵģ�����b�ķ�����hashmap�У���b�ķ�����ԭ�ַ�������b�ķ����Ӧ���ַ������ַ�������ɻ����ַ�����
 */
public class Q336 {
	public List<List<Integer>> palindromePairs(String[] words) {
		HashSet<List<Integer>> res = new HashSet<List<Integer>>();
		if (words == null || words.length < 2)
			return new ArrayList<List<Integer>>(res);
		HashMap<String, Integer> map = new HashMap<String, Integer>(words.length);
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String a = words[i].substring(0, j);
				String b = words[i].substring(j);
				String c = new StringBuilder(a).reverse().toString();
				String d = new StringBuilder(b).reverse().toString();
				Integer it = map.get(c);
				Integer it2 = map.get(d);
				if (check(b) && it != null && it != i) {
					res.add(Arrays.asList(i, it));
				}
				if (check(a) && it2 != null && it2 != i) {
					res.add(Arrays.asList(it2, i));
				}
			}
		}
		return new ArrayList<List<Integer>>(res);
	}

	public boolean check(String a) {
		char[] c = a.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != c[c.length - 1 - i])
				return false;
		}
		return true;
	}
}
