package easy;

/*
 * 2016.7.7
 * ����һ����ԭ26���Ƶ����֡�ûʲô��˵�ġ�
 */
public class Q171 {
	public int titleToNumber(String s) {
		int res = 0;
		int down = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			int middle = down * (s.charAt(i) - 'A' + 1);
			res = res + middle;
			down = down * 26;
		}
		return res;
	}
}
