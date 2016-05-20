package medium;

/*
 * 2016.5.20
 * ���͵Ķ�̬�滮����Ŀ������̨�׷ǳ����ƣ�ֻ����������Ҫ��ܶࡣ
 * ����һ������Ϊs.length()+1��dp���飬dp[i]��ʾ��s[0...i-1]�ж�����ת�������
 * ��ʼ������1.��������ַ����ǿգ����ߵ�һλ��0��ֱ�����0��
 * ����dp[i]�������һλ��0����ôֻ�ܺ͵�i-2λ�����λ�������룬�������ǰһλҲ��0����ǰһλ�͵�ǰλ�޷���ɿ��Խ�������֣�ֱ�ӷ���0
 * ���������ɣ���ôdp[i]=dp[i-2]
 * �����һλ����0�����ҿ��Ժ�ǰһλ���1��26�����֣���dp[i]=dp[i-1]+dp[i-2];
 * ����dp[i]=dp[i-1]
 */
public class Q91 {
	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if (s.length() == 1)
			return 1;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '0') {
				if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') > 26 || s.charAt(i - 2) == '0') {
					return 0;
				} else {
					dp[i] = dp[i - 2];
				}
			} else {
				if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') > 26 || s.charAt(i - 2) == '0') {
					dp[i] = dp[i - 1];
				} else {
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}
		}
		return dp[s.length()];
	}
}
