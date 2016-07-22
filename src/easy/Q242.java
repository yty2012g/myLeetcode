package easy;

/*
 * 2016.7.22
 * ��������ȷ��ֻ��Сд��ĸ�������������ٶȻ��ܶࡣ
 * ��һ�������¼ÿһ����ĸ���ֵĴ�����
 * �ȱ���s�����ֵ���ĸ����+1��
 * �ڱ���t,���ֵ���Ļ����-1���������Ϊ�������򷵻�false��
 * ����true��
 */
public class Q242 {
	public boolean isAnagram(String s, String t) {
		int[] times = new int[26];
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;
		for (int i = 0; i < s.length(); i++) {
			times[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			times[t.charAt(i) - 'a']--;
			if (times[t.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
}
