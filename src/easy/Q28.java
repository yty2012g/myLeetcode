package easy;

/*
 * 2016.5.7
 * 字符串匹配的问题，这里只用了最简单粗暴的方法。后续还会补充，kmp，有限状态机的方法。
 * 最简单的方法就是，一位一位查找，如果找到一位字符和needle头字符匹配，则从此字符开始依次和needle匹配。
 * 
 * 2016.8.20 update
 * 实现了两种KMP算法，基于状态机和基于next数组，但是题目不利于这样做，而且感觉没有大数据集。效果不如朴素算法。
 * 蛋疼。
 * 
 * 2016.8.20 第二次update
 * 我做了多组实验
 * 第一组，待匹配字符串由"abcdefghijklmnopqrstuvwxyz"的若干前缀子串构成，模式字符串为"abcdefghijklmnopqrstuvwxyz"或其子串
 * 第二组，待匹配字符串不变，模式字符串使用非小写字符组成。
 * 第三组，待匹配字符串不变，模式字符串使用小写字符，但不是其子串
 * 
 * 结果：
 * 第一组，basic方法时间数倍于其他两种方法，next和dfs相比，dfs较快，差距在50%以内。
 * 第二组，basic方法时间变化很小，next方法比dfs慢的时间扩大为80%以上。
 * 第三组，basic方法变化很小，next方法比dfs方法通常慢100%。
 * 
 * 可以看出，dfs方法和basic方法的时间变化很小，next方法收到模式字符串和待匹配字符串关系的影响。
 * 但是相比较next方法，dfs方法时间更短，更加稳定。并且dfs没有比较的过程，所以显然时间会更短。
 * dfs之所以稳定，是因为，dfs只有当前状态+输入字符=输出状态，这一种变化，而在dfs构建好以后，稳定的只需要O(N)的时间。
 */
public class Q28 {
	public String test = "";

	public void build() {
		StringBuilder sb = new StringBuilder();
		String s = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 20000000; i++) {
			sb.append(s.substring(0, (int) (Math.random() * 24 + 1)));
		}
		sb.append(s);
		this.test = sb.toString();
	}

	public int strStr(String haystack, String needle) {
		int size = needle.length();
		int size2 = haystack.length();
		if (size == 0)
			return 0;
		if (size2 == 0 || size2 < size)
			return -1;
		int[] next = new int[size];
		next[0] = -1;
		int j = -1, i = 0;
		while (i < size - 1) {
			if (j == -1 || needle.charAt(j) == needle.charAt(i)) {
				next[++i] = ++j;
			} else {
				j = next[j];
			}
		}
		i = 0;
		j = 0;
		while (i < size2 && j < size) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == size)
			return i - j;
		else
			return -1;
	}

	public int KMPviaNext(String h, String n) {
		int[] next = new int[n.length()];
		next[0] = 0;
		int k = 0;
		for (int i = 1; i < n.length(); i++) {
			if (k > 0 && n.charAt(i) != n.charAt(k)) {
				k = next[k - 1];
			}
			if (n.charAt(i) == n.charAt(k)) {
				k++;
			}
			next[i] = k;
		}
		for (int i = 0, j = 0; i < h.length(); i++) {
			while (j > 0 && h.charAt(i) != n.charAt(j))
				j = next[j - 1];
			if (h.charAt(i) == n.charAt(j))
				j++;
			if (j == n.length())
				return i - j + 1;
		}
		return -1;
	}

	public int KMPviaDFS(String h, String n) {
		int R = 256;
		int[][] dict = new int[R][n.length()];
		int x = 0;
		dict[n.charAt(0)][0] = 1;
		for (int i = 1; i < n.length(); i++) {
			for (int j = 0; j < R; j++) {
				dict[j][i] = dict[j][x];
			}
			dict[n.charAt(i)][i] = i + 1;
			x = dict[n.charAt(i)][x];
		}
		x = 0;
		for (int i = 0; i < h.length(); i++) {
			x = dict[h.charAt(i)][x];
			if (x == n.length()) {
				return i - n.length() + 1;
			}
		}
		return -1;

	}

	public int basic(String haystack, String needle) {
		if (needle.length() == 0)
			return -1;
		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle))
				return i;
		}
		return -1;
	}
}
