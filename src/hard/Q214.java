package hard;

public class Q214 {
	public String shortestPalindrome(String s) {
		String before = "";
		String after = "";
		int b = 0;
		int a = s.length() - 1;
		while (b < a) {
			if (s.charAt(b) == s.charAt(a)) {
				before = before + s.charAt(b);
				after = s.charAt(a) + after;
				b++;
				a--;
			} else {
				before = before + s.charAt(a);
				after = s.charAt(a) + after;
				a--;
			}
		}
		String res = "";
		if (a == b) {
			res = before + s.charAt(a) + after;
		} else {
			res = before + after;
		}
		return res;
	}
}
