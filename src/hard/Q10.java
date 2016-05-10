package hard;
/*
 * 2016.5.3
 * ����һ������ʹ�ö�̬�滮����Ŀ��s��Դ�ַ�����p��������ʽ��Ҫ��pƥ��s��Ҫ��1.'.' ���Ա�ʾ����һ���ַ� 2.'*'��ʾ*��ǰ���ַ����Գ������ɴΣ�����0
 * dp[i][j]��ʾ��s[0...i]ƥ��p[0...j]�Ƿ�ɹ���
 * 
 * isMath�����ǿռ临�Ӷ�ΪO(nƽ��)�ķ�����
 * isMath2�ռ临�Ӷ�ΪO(2n)����Ϊÿһ���ж�ֻ��Ҫ������һ�е����ݼ��ɡ�
 * 
 */
public class Q10 {
	public boolean isMatch(String s, String p) {
		int lens = s.length();
		int lenp = p.length();
		if (lens == 0 && lenp == 0)
			return true;
		boolean[][] dp = new boolean[lens + 1][lenp + 1];
		dp[0][0] = true;
		// ��ʼ����ÿ���ַ���ǰ���ȼ���һ�����ַ������Ե�һ�б�ʾ�����ַ�ƥ��p[0...j]���ɹ���������Ϊp����һ���ַ���һ��*�������������ɵġ�
		for (int i = 2; i <= lenp; i++) {
			dp[0][i] = (p.charAt(i - 1) == '*' && dp[0][i - 2]) ? true : false;
		}
		//�κ��ַ���ƥ����ַ�����ʧ�ܵġ�
		for (int i = 1; i <= lens; i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= lens; i++) {
			for (int j = 1; j <= lenp; j++) {
				if (p.charAt(j - 1) == '*') {//��һ����ܣ���ǰ�ַ���һ��*��
					//������1��*��ǰ���ַ����ִ��ڵ���1�Ρ������ǵ�ǰ�Ƚ��ַ�����*��ǰ���ַ�����*��ǰ���ַ���.��
					//���ȥ����ǰ�ַ�ƥ��p[0...j]��Ȼ�ɹ������������ǰ�ַ����ظ����ֵ��ַ���ƥ��ɹ���
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i - 1][j] ? true : false;
					}
					//�����ǰ�ַ�����*��ǰ���ַ��������*��ǰ���ַ�����0�Σ�����ͨ����p[0...j-2]ƥ�䣬�ж��Ƿ�*��ǰ���ַ�����0�Ρ�
					if (j >= 2 && dp[i][j - 2])
						dp[i][j] = true;
				} else {//�����ǰ�ַ�����*�ţ���Ƚ�s[i]��p[j]�Ƿ���ȡ���ȵĻ���ȡ����s[0..i-1]��p[0...j-1]ƥ���Ƿ�ɹ���
					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
						dp[i][j] = dp[i - 1][j - 1] ? true : false;
					}
				}
			}
		}
		print(dp, lens + 1, lenp + 1);
		return dp[lens][lenp];
	}

	public void print(boolean[][] a, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isMatch2(String s, String p) {
		int lens = s.length();
		int lenp = p.length();
		if (lens == 0 && lenp == 0)
			return true;

		// init
		boolean[][] dp = new boolean[2][lenp + 1];
		dp[0][0] = dp[1][0] = true;
		for (int j = 2; j <= lenp; ++j) {
			if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
				dp[0][j] = dp[1][j] = true;
			}
		}

		// dp
		for (int i = 1; i <= lens; ++i) {
			dp[i & 1][0] = false;
			for (int j = 1; j <= lenp; ++j) {
				dp[i & 1][j] = ((p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
						&& dp[1 - (i & 1)][j - 1])
						|| p.charAt(j - 1) == '*' && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')
								&& dp[1 - (i & 1)][j]
						|| (j >= 2 && p.charAt(j - 1) == '*' && dp[i & 1][j - 2]);
			}
		}

		return dp[lens & 1][lenp];
	}
}
