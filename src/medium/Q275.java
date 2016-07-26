package medium;

/*
 * 2016.7.26
 * 做法同Q274，时间复杂度为O（logN）
 */
public class Q275 {
	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return citations.length;
		if (citations.length == 1) {
			if (citations[0] == 0)
				return 0;
			else
				return 1;
		}
		int small = 0;
		int big = citations.length - 1;
		while (small <= big) {
			int middle = (small + big) / 2;
			int h = citations.length - middle;
			if (citations[middle] >= h) {
				if (middle == 0)
					return h;
				else {
					if (citations[middle - 1] <= h) {
						return h;
					} else {
						big = middle;
					}
				}
			} else {
				small = middle + 1;
			}
		}
		return 0;
	}
}
