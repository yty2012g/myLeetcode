package medium;
/*
 * 2016.8.18
 * 灌水定理：用a1,a2...aN这N个壶可以得到的水的容量L的充要条件是：
 * 第一，L<=a1+a2+...aN
 * 第二，L可以被（a1,a2...aN）的最大公约数整除。
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
