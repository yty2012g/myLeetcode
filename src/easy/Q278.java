package easy;

/*
 * 2016.7.26
 * �Ҿ�֪���������Ƕ��ַ����������޵Ĵ���
 * Ϊ�����������Ҫʹ��middle=(big+small)/2��
 * Ӧ��ʹ��middle=(big-small)/2+small;
 */
public class Q278 {
	public boolean isBadVersion(int version) {
		return true;
	}

	public int firstBadVersion(int n) {
		int small = 1;
		int big = n;
		int res = -1;
		while (small <= big) {
			int middle = small + (big - small) / 2;
			if (isBadVersion(middle)) {
				big = middle - 1;
				res = res == -1 ? middle : Math.min(middle, res);
			} else {
				small = middle + 1;
			}
		}
		return res;
	}
}
