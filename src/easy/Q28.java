package easy;

/*
 * 2016.5.7
 * �ַ���ƥ������⣬����ֻ������򵥴ֱ��ķ������������Ჹ�䣬kmp������״̬���ķ�����
 * ��򵥵ķ������ǣ�һλһλ���ң�����ҵ�һλ�ַ���needleͷ�ַ�ƥ�䣬��Ӵ��ַ���ʼ���κ�needleƥ�䡣
 * 
 * 2016.8.20 update
 * ʵ��������KMP�㷨������״̬���ͻ���next���飬������Ŀ�����������������Ҹо�û�д����ݼ���Ч�����������㷨��
 * ���ۡ�
 * 
 * 2016.8.20 �ڶ���update
 * �����˶���ʵ��
 * ��һ�飬��ƥ���ַ�����"abcdefghijklmnopqrstuvwxyz"������ǰ׺�Ӵ����ɣ�ģʽ�ַ���Ϊ"abcdefghijklmnopqrstuvwxyz"�����Ӵ�
 * �ڶ��飬��ƥ���ַ������䣬ģʽ�ַ���ʹ�÷�Сд�ַ���ɡ�
 * �����飬��ƥ���ַ������䣬ģʽ�ַ���ʹ��Сд�ַ������������Ӵ�
 * 
 * �����
 * ��һ�飬basic����ʱ���������������ַ�����next��dfs��ȣ�dfs�Ͽ죬�����50%���ڡ�
 * �ڶ��飬basic����ʱ��仯��С��next������dfs����ʱ������Ϊ80%���ϡ�
 * �����飬basic�����仯��С��next������dfs����ͨ����100%��
 * 
 * ���Կ�����dfs������basic������ʱ��仯��С��next�����յ�ģʽ�ַ����ʹ�ƥ���ַ�����ϵ��Ӱ�졣
 * ������Ƚ�next������dfs����ʱ����̣������ȶ�������dfsû�бȽϵĹ��̣�������Ȼʱ�����̡�
 * dfs֮�����ȶ�������Ϊ��dfsֻ�е�ǰ״̬+�����ַ�=���״̬����һ�ֱ仯������dfs�������Ժ��ȶ���ֻ��ҪO(N)��ʱ�䡣
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
