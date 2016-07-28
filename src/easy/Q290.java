package easy;

import java.util.*;

/*
 * 2016.7.28
 * ��Ŀ�ܼ򵥣�Ҫ��pattern��str��˫��ģ���һһ��Ӧ������û�����µġ�
 * ����ʹ��map��¼��ĸ->���ʣ�ʹ��map2��¼����->��ĸ��
 * ���������һ���µĵ�����ĸ���ԣ��������������map��map2�У���ô���Ǳ��뻥���Ӧ�����򷵻�false��
 * �����ֻ������map����map2�У�����false����Ϊ��һһ��Ӧ�Ĺ�ϵ��
 * ������ĸ���û�г��֣�����map��map2������ӳ���ϵ��
 */
public class Q290 {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>(26);
		HashMap<String, Character> map2 = new HashMap<String, Character>(26);
		String[] sc = str.split(" ");
		if (sc.length != pattern.length())
			return false;
		for (int i = 0; i < sc.length; i++) {
			if (map.containsKey(pattern.charAt(i)) && map2.containsKey(sc[i])) {
				if (map.get(pattern.charAt(i)).equals(sc[i]) && map2.get(sc[i]).equals(pattern.charAt(i))) {
				} else
					return false;
			} else if ((!map.containsKey(pattern.charAt(i)) && map2.containsKey(sc[i]))
					|| (map.containsKey(pattern.charAt(i)) && !map2.containsKey(sc[i]))) {
				return false;
			} else {
				map.put(pattern.charAt(i), sc[i]);
				map2.put(sc[i], pattern.charAt(i));
			}
		}
		return true;
	}
}
