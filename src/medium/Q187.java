package medium;

import java.util.*;

/*
 * 2016.7.8
 * 使用一个arrayList记录结果，一个hashset剔除原始结果集中的重复项，hashmap记录出现过的dna序列。
 * 每次提取长度为10的序列，如果hashmap中存在，则加入原始结果集，如果不存在就加入hashmap中。
 * 遍历hashset即可得到最终结果。
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
