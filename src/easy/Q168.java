package easy;

/*
 * 2016.7.7
 * ��2���Ʋ�ͬ��ʱ��26���Ƶ�0�������z������һ�����ڵõ�������ʱ����Ҫ�ж������Ƿ���0�������0���Ǽ���Z
 * ÿ�εõ�һλ����ֱ�ӳ���26����Ϊ����Ϊ0ʱ��Ӧ�ü�ȥ26.����Ҫ���������жϡ�
 */
public class Q168 {
	public String convertToTitle(int n) {
		String res = "";
		if (n <= 0)
			return res;
		while (n > 0) {
			int m = n % 26;
			char temp = m == 0 ? 'Z' : (char) ('A' + m - 1);
			res = temp + res;
			n = m == 0 ? (n - 26) / 26 : (n - m) / 26;
		}
		return res;
	}
}
