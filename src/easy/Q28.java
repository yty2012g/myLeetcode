package easy;
/*
 * 2016.5.7
 * �ַ���ƥ������⣬����ֻ������򵥴ֱ��ķ������������Ჹ�䣬kmp������״̬���ķ�����
 * ��򵥵ķ������ǣ�һλһλ���ң�����ҵ�һλ�ַ���needleͷ�ַ�ƥ�䣬��Ӵ��ַ���ʼ���κ�needleƥ�䡣
 */
public class Q28 {
	public int strStr(String haystack, String needle) {
		int len = haystack.length();
		if (needle.length() > len)
			return -1;
		if (len == 0 || needle.length() == 0)
			return 0;

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				for (int j = 0; j < needle.length(); j++) {
					if (haystack.charAt(i + j) != needle.charAt(j))
						break;
					if (j == needle.length() - 1)
						return i;
				}
			}
		}
	}
}
