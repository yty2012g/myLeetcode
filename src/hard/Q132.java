package hard;

import java.util.ArrayList;
import java.util.List;

public class Q132 {
	public int minCut(String s) {
		min = s.length();
		part(s, 0, new ArrayList<String>());
		return min - 1;
	}

	int min = 0;

	public void part(String s, int start, ArrayList<String> array) {
		if (min <= array.size())
			return;
		if (start == s.length()) {
			min = Math.min(min, array.size());
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);
			if (check(sub)) {
				array.add(sub);
				part(s, i, array);
				array.remove(array.size() - 1);
			}
		}
	}

	public boolean check(String s) {
		int i = 0;
		while (i < s.length() - 1 - i) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
			i++;
		}
		return true;
	}
}
