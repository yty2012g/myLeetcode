package hard;

import java.util.*;

public class Q97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		if (s1.length() == 0)
			return s2.equals(s3);
		if (s2.length() == 0)
			return s1.equals(s3);
		if (s3.charAt(0) != s1.charAt(0) && s3.charAt(0) == s2.charAt(0))
			return isInterleave(s2, s1, s3);
		if (s3.charAt(0) != s1.charAt(0))
			return false;
		ArrayList<Integer> num = new ArrayList<Integer>();
		int s1flag = 0;
		for (int i = 0; i < s3.length(); i++) {
			if (s1flag < s1.length() && s3.charAt(i) == s1.charAt(s1flag)) {
				s1flag++;
			} else {
				num.add(i);
			}
		}
		if (s1flag != s1.length())
			return false;
		for (int i = 0; i < num.size(); i++) {
			if (s3.charAt(num.get(i)) != s2.charAt(i))
				return false;
		}
		return true;
	}
}
