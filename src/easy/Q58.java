package easy;

/*
 * 2016.5.14
 * �������ǰ�������ӽ�β��ʼ��һ�����ǿո��ַ����ַ���ʼ������������ַ����ı��������г��ֿո��򷵻ؼ���ֵ�����û��Ҳ���ؼ���ֵ�������ַ���ֻ��һ������
 */
public class Q58 {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0)
			return 0;
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && res == 0)
				continue;
			if (s.charAt(i) != ' ')
				res++;
			if (s.charAt(i) == ' ' && res != 0)
				return res;
		}
		return res;
	}
}
