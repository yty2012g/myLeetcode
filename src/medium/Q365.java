package medium;
/*
 * 2016.8.18
 * ��ˮ������a1,a2...aN��N�������Եõ���ˮ������L�ĳ�Ҫ�����ǣ�
 * ��һ��L<=a1+a2+...aN
 * �ڶ���L���Ա���a1,a2...aN�������Լ��������
 */
public class Q365 {
	public boolean canMeasureWater(int x, int y, int z) {
		if (x == 0 || y == 0) {
			return z == x || z == y;
		}
		if (z > x + y)
			return false;
		return z % m(x, y) == 0;
	}

	public int m(int x, int y) {
		int max = Math.max(x, y);
		int min = Math.min(x, y);
		if (max % min == 0)
			return min;
		return m(min, max % min);
	}
}
