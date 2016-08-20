package hard;

import java.util.*;

/*
 * 2016.8.20
 * �����Ŀ���˵ĵ�һӡ�����ʹ������������У�LIS���Ļ��ڶ��������ķ���������
 * ��������һ���ϰ������������ŷ⣨x1,y1����(x2.y2)��˵�������x1����x2���������Ӧ�ð�y��ķ���ǰ�滹�Ǻ��档
 * ��Ϊ���ڶ��������ķ�������ά����һ����������len��len[i]��ʾ����Ϊi���������һ��Ԫ����С�����Ƕ��١��������������޷��Ƚϵġ�
 * ��ˣ������ʹ�û��ڶ��ֵķ�����ʱ������600ms���ң���Ҫ��0ɨ�赽i���ҵ��ܹ����ǵģ�������Ǹ��ŷ⣬Ȼ�󳤶ȼ�1.
 * 
 * ---------------------------------------------------------------------------
 * ���ǣ�����ķ������ǲ�һ�������Ȼ�����Ҫ���򣬵��Ƕ���x1==x2������£���y�ϴ�ķ���ǰ�档
 * ����������Ժ�x��������ģ�����y���ǣ����൱��ת�����ˣ��ҵ�y����ĵ��������У�����x1==x2ʱ���ϴ��y��ǰ�档
 * ���Ե�y1>y2ʱ��x1һ����С��x2�ģ���Ϊ�����ʱ���ȱȽϽϴ��y���ڱȽϽ�С��y��
 * ����(1,1)(2,3)(2,4)(3,5)(3,4)������У�
 * ������յ�һ������ʽ�õ����ǣ�(1,1)(2,3)(2,4)(3,4)(3,5)�����Ƚϵ�3��Ԫ�أ�2��4����ʱ��Ҫ��Ҫ������Ϊ2�������е����һ��Ԫ�ص�ֵ�ĳɣ�2��4���������û�а취�жϵġ�
 * ����������յ�һ������ʽ�õ��ǣ�(1,1)(2,4)(2,3)(3,5)(3,4)�����Ժ����Կ���yֵ����������������е����⡣
 */
public class Q354 {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0 || envelopes[0].length != 2)
			return 0;
		Comparator<int[]> com = new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if (arg0[0] == arg1[0]) {
					return arg1[1] - arg0[1];
				} else {
					return arg0[0] - arg1[0];
				}
			}

		};
		Arrays.sort(envelopes, com);
		int[] dp = new int[envelopes.length];
		int len = 0;
		for (int i = 0; i < envelopes.length; i++) {
			int index = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
			if (index < 0) {
				index = -1 * (index + 1);
			}
			dp[index] = envelopes[i][1];
			if (index == len)
				len++;
		}
		return len;
	}

	public int shunxu(int[][] envelopes) {
		int m = envelopes.length;
		if (m == 0)
			return 0;
		Comparator<int[]> com = new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if (arg0[0] > arg1[0]) {
					return 1;
				} else if (arg0[0] < arg1[0]) {
					return -1;
				} else {
					if (arg0[1] > arg1[1])
						return 1;
					else if (arg0[1] < arg1[1])
						return -1;
					else
						return 0;
				}
			}

		};
		Arrays.sort(envelopes, com);
		int[] dp = new int[m];
		dp[0] = 1;
		int mm = 1;
		for (int i = 1; i < m; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (can(envelopes[j], envelopes[i])) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = max + 1;
			mm = Math.max(mm, dp[i]);
		}
		return mm;
	}

	public boolean can(int[] arg0, int[] arg1) {
		if (arg0[0] < arg1[0] && arg0[1] < arg1[1])
			return true;
		else
			return false;
	}
}
