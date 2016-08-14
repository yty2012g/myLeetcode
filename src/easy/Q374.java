package easy;

/*
 * 2016.8.14
 * ������Ķ���������
 * Ҫ��1��ѭ��������s<e�����ǵ���
 * Ҫ��2���޸ı߽�ʱҪ+1����-1
 */
public class Q374 {
	int guess(int num) {
		return 0;
	}

	public int guessNumber(int n) {
		int s = 1;
		int e = n;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (guess(m) > 0) {
				s = m + 1;
			} else if (guess(m) == 0) {
				return m;
			} else {
				e = m - 1;
			}
		}
		return s;
	}
}
