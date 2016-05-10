package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/*
 * 2016.5.9
 * �����Ƚϼ򵥣����Ǹ�����һ�ε��ַ����õ���һ�ε��ַ�����
 * ����ʹ��һ��HashMap�����һ���ַ�û�г�����hashmap�У�˵��ǰ���һ���ַ��Ѿ���������˽�����ϡ�����+ǰһ���ַ���
 * ע���ǣ������һ�Σ���Ҫ��hashmapʣ������һ���ַ�д�����С�
 */
public class Q38 {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		String old = "1";
		for (int i = 2; i <= n; i++) {
			old = say(old);
		}
		return old;
	}

	public String say(String old) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String res = "";
		map.put(old.charAt(0), 1);
		for (int i = 1; i < old.length(); i++) {
			if (map.get(old.charAt(i)) == null) {
				Iterator iter = map.entrySet().iterator();
				Map.Entry entry = (Entry) iter.next();
				res = res + entry.getValue() + entry.getKey();
				map.clear();
				map.put(old.charAt(i), 1);
			} else {
				map.put(old.charAt(i), map.get(old.charAt(i)) + 1);
			}
		}
		Iterator iter = map.entrySet().iterator();
		Map.Entry entry = (Entry) iter.next();
		res = res + entry.getValue() + entry.getKey();
		return res;
	}
}
