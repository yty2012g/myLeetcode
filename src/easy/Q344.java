package easy;

/*
 * 2016.8.24
 * ���ַ�������һ�־�����ת����char[]��Ȼ�������
 * �ڶ��֣�ʹ��stringbuilder��Ȼ�����stringbuilder����β������
 * �ҷ��֣�������ı�string�ĳ��ȣ��ܶ�ʱ�򣬻���char[]Ч�ʸ��ߡ�
 */
public class Q344 {
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		char[] sc = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i++) {
			sb.append(sc[i]);
		}
		return sb.toString();
	}

	public String reverseString2(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0, l = s.length(); i < l / 2; i++) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(l - 1 - i));
			sb.setCharAt(l - 1 - i, temp);
		}
		return sb.toString();
	}
}
