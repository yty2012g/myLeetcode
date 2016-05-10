package medium;

import java.util.*;

/*
 * 2016.5.10
 * �������������Ƕ���ÿһ���ַ�������ת����һ�������arraylist��Ȼ�������arraylist��Ϊhashmap�е�key��valueΪ����key��String��arraylist
 * ��Ϊ���ڰ���ͬ���ַ����ַ������ԣ��ַ�����Ӧ��������ַ�������Ψһ�ģ�������Ϊkeyֵ
 */
public class Q49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs.length == 0)
			return res;
		ArrayList<String> empty = new ArrayList<String>();
		HashMap<ArrayList<Character>, ArrayList<String>> map = new HashMap<ArrayList<Character>, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() == 0) {
				empty.add("");
				continue;
			}
			ArrayList<Character> array = new ArrayList<Character>();
			for (int j = 0; j < strs[i].length(); j++) {
				array.add(strs[i].charAt(j));
			}
			Collections.sort(array);
			if (map.get(array) == null) {
				ArrayList<String> a = new ArrayList<String>();
				a.add(strs[i]);
				map.put(array, a);
			} else {
				map.get(array).add(strs[i]);
			}
		}
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Collections.sort((ArrayList<String>) entry.getValue());
			res.add((ArrayList<String>) entry.getValue());
		}
		if (empty.size() != 0)
			res.add(empty);
		return res;
	}
}
