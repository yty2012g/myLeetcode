package easy;

/*
 * 2016.7.2
 * check�����������Ǽ��һ���ַ��Ƿ������ֻ�����ĸ��
 * ʹ��start��end�����α꣬ÿ�ж�һ���α�ͱ仯һ�Σ����startָ����ַ��ǷǷ��ģ���start����һ�Σ����endָ��Ƿ�����end����
 * ��ֹ�ı�׼��start>=end�����Լ�ʹ�ǿ��ַ�����Ҳ���ж�Ϊtrue��
 * ��������Ϸ����ַ�����ȣ��򷵻�false��
 */
public class Q125 {
	public boolean isPalindrome(String s) {
		String temp = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!check(temp.charAt(start))) {
				start++;
				continue;
			}
			if (!check(temp.charAt(end))) {
				end--;
				continue;
			}
			if (temp.charAt(start) != temp.charAt(end))
				return false;
			else {
				start++;
				end--;
			}
		}
		return true;
	}

	public boolean check(char i) {
		if ((i <= 'z' && i >= 'a') || (i >= '0' && i <= '9'))
			return true;
		return false;
	}
}
