package hard;

import java.util.*;

public class Q76 {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			if (map.get(t.charAt(i)) == null) {
				map.put(t.charAt(i), 1);
			} else {
				map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
			}
		}
		int start = -1;
		int end = 0;
		int size = map.size();
		int min = -1;
		int ms = 0;
		int me = 0;
		boolean flag = false;
		HashMap<Character, Integer> copy = (HashMap<Character, Integer>) map.clone();
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) != null) {
				if (start == -1)
					start = i;
				copy.put(s.charAt(i), copy.get(s.charAt(i)) - 1);
				if (copy.get(s.charAt(i)) == 0)
					size--;
				if (size == 0) {
					end = i;
					if (min == -1 || min > end - start + 1) {
						ms = start;
						me = end;
						min = end - start + 1;
					}
				}

				if (end != 0 && size == 0) {
					if (!flag) {
						flag = true;
						continue;
					}
					for (int j = start; j <= end; j++) {
						if (map.containsKey(s.charAt(j))) {
							copy.put(s.charAt(j), copy.get(s.charAt(j)) + 1);
							if (copy.get(s.charAt(j)) > 0)
								size++;
							if (size > 0) {
								start = j;
								break;
							}
						}
					}
					if (end - start + 1 == t.length())
						return s.substring(start, end + 1);
				}
			}
		}
		return s.substring(ms, me + 1);
	}
}
