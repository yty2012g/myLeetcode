package hard;

/*
 * 2016.5.10
 * �����ǰ���Ǹ�������ʽƥ��ʱ�ǳ����Ƶģ��������в�ͬ�������������һ���ַ���*�������ɸ��ַ�
 * ���ö�̬�滮�ķ�����dp[i][j]��ʾs[0..i-1]��p[0...j-1]ƥ��Ľ��
 * ����1�����s�ĵ�ǰ�ַ�����p�ĵ�ǰ�ַ�����p��ǰΪ?�ţ���ô���s[0..i-2]��p[0...j-2]ƥ��Ľ���ǳɹ��������ǳɹ��ģ�������Ϊʧ��
 * ����2���������������1�������ǰp���ַ���*�ţ����������������һ��*�Ŵ���0���ַ����ڶ���*�Ŵ������ַ�
 * ����ǵ�һ������������dp[i][j-1]�Ľ�����������û�����*����Ȼ�ǳɹ��ģ���*�Ŵ���0���ַ���ƥ��ɹ�
 * ����ǵڶ�����������dp[k][j-1]��Ѱ�ң�0<=k<i�������һ��kֵ��ʹ��dp[k][j-1]�ɹ�����˵��k����i-1���ַ���p�п�����*�Ŵ������ɹ�
 * ����3������ַ�����ȣ�ƥ��ʧ�ܡ�
 * 
 */
public class Q44 {
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= p.length(); i++) {
			dp[0][i] = (dp[0][i - 1] && p.charAt(i - 1) == '*') ? true : false;
		}
		for (int i = 1; i <= s.length(); i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					if (dp[i - 1][j - 1])
						dp[i][j] = true;
				} else {
					if (p.charAt(j - 1) == '*') {
						if (dp[i][j - 1])
							dp[i][j] = true;
						else {
							for (int k = i - 1; k >= 0; k--) {
								if (dp[k][j - 1]) {
									dp[i][j] = true;
									break;
								}
							}
						}
					} else {
						dp[i][j] = false;
					}

				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
