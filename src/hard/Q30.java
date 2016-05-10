package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * 2016.5.8
 * �����ܼ򵥺���⣬����ʹ��һ��hashmapͳ��words����ÿ�����ʺͳ��ֵĴ�������Ϊ���ﵥ���ǿ����ظ��ġ�
 * Ȼ�󣬶����ַ���s��ÿһλ�Ŀ�ʼ���ң�����words����ĵ��ʳ��ȶ�����ͬ�ģ�����һ�αȽϳ���Ϊwordl���Ӵ����ɡ�
 * ÿһ��ƥ�䣬�õ�һ��hashmap�Ŀ�¡������Ӵ�û�г�����hashmap�У����߳��ֵĴ���������words����Ĵ�����ֱ��ֹͣ��
 * ����Ӧ�õ��˻������ڵĸ�����ƥ��ɹ�����ô���ƥ��wordl*len�ĳ��ȣ�����������ȵľͲ��ñȽϡ�
 * ���������ʱ����125ms��
 * �����ʹ�û������ڵĸ����ֹͣ�������ǳ���һ��ƥ�䲻�ɹ���Ҳ����ÿһ�γɹ�ƥ����ַ������Ƚ�һ�Σ�����ʱ��᳤һ��
 * 129ms
 */
public class Q30 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (words.length == 0 || words[0].length() == 0)
			return res;
		int wordl = words[0].length();
		int len = words.length;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			if (map.get(words[i]) == null)
				map.put(words[i], 1);
			else
				map.put(words[i], map.get(words[i]) + 1);
		}
		for (int i = 0; i < s.length() - len * wordl + 1; i++) {
			HashMap<String, Integer> copy = (HashMap<String, Integer>) map.clone();
			for (int start = i; start < i + wordl * len; start = start + wordl) {
				String sub = s.substring(start, start + wordl);
				if (copy.get(sub) == null)
					break;
				else {
					int times = copy.get(sub);
					times--;
					if (times == 0)
						copy.remove(sub);
					else
						copy.put(sub, times);
				}
			}
			if (copy.size() == 0)
				res.add(i);
		}
		return res;
	}

	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (words.length == 0 || words[0].length() == 0)
			return res;
		int wordl = words[0].length();
		int len = words.length;
		ArrayList<String> word = new ArrayList<String>();
		for (int i = 0; i < len; i++) {
			word.add(words[i]);
		}

		for (int i = 0; i < s.length() - len * wordl; i++) {
			int start = i;
			ArrayList<String> copy = new ArrayList<String>();
			for (int j = 0; j < len; j++) {
				copy.add(word.get(j));
			}
			while (start < s.length() - wordl + 1) {
				if (copy.remove(s.substring(start, start + wordl))) {
					start = start + wordl;
				} else
					break;
			}
			if (copy.size() == 0)
				res.add(i);
		}
		return res;
	}

	public void print(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
	}
}
