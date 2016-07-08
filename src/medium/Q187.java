package medium;

import java.util.*;

/*
 * 2016.7.8
 * ʹ��һ��arrayList��¼�����һ��hashset�޳�ԭʼ������е��ظ��hashmap��¼���ֹ���dna���С�
 * ÿ����ȡ����Ϊ10�����У����hashmap�д��ڣ������ԭʼ���������������ھͼ���hashmap�С�
 * ����hashset���ɵõ����ս����
 */
public class Q187 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String temp = s.substring(i, i + 10);
			if (map.containsKey(temp)) {
				set.add(temp);
			} else {
				map.put(temp, 1);
			}
		}
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			res.add(iter.next());
		}
		return res;
	}
}
