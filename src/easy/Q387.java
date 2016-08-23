package easy;

/*
 * 2016.8.23
 * 这里在得到每一个字符的部分使用了两种方法。
 * 方法一，在一开始将string转换成char[]，然后按照数组的方式访问。
 * 方法二，使用string.charAt来访问每一个位置。
 * 实践证明，方法1 18ms，方法2 28ms。
 */
public class Q387 {
	public int firstUniqChar(String s) {
		char[] sc = s.toCharArray();
		int[] times = new int[26];
		int[] pos = new int[26];
		for (int i = 0; i < 26; i++) {
			pos[i] = -1;
		}
		for (int i = 0, l = sc.length; i < l; i++) {
			times[sc[i] - 'a']++;
			pos[sc[i] - 'a'] = i;
		}
		int res = -1;
		for (int i = 0; i < 26; i++) {
			if (times[i] == 1)
				res = res == -1 ? pos[i] : Math.min(res, pos[i]);
		}
		return res;
	}

	public int firstUniqChar2(String s) {
		int[] times = new int[26];
		int[] pos = new int[26];
		for (int i = 0; i < 26; i++) {
			pos[i] = -1;
		}
		for (int i = 0, l = s.length(); i < l; i++) {
			times[s.charAt(i) - 'a']++;
			pos[s.charAt(i) - 'a'] = i;
		}
		int res = -1;
		for (int i = 0; i < 26; i++) {
			if (times[i] == 1)
				res = res == -1 ? pos[i] : Math.min(res, pos[i]);
		}
		return res;
	}
}
