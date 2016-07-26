package medium;

import java.util.Arrays;

/*
 * 2016.7.26
 * 首先对数组进行排序。时间复杂度为O(nlogn)
 * 然后，使用二分搜索的思想。
 * 对于一个数组，如果存在h，那么从len-h开始的数字都是大于等于h，之前的数字都是小于等于h。
 * 首先从整个数组开始二分，得到middle，那么h就等于len-middle
 * 如果middle位置的元素大于h，如果middle已经等于0，则不必继续找，此时的h最大。直接返回。
 *                            如果middle-1位置的元素也恰好小于等于h，由于此时数组有序，那么middle之前的元素也都是小于等于h的。直接返回h。
 * 否则，扩大h的范围，即big等于middle。因为h=len-middle，减小big，就减小middle，因此扩大了h。
 * 如果middle位置的元素小于h，那么缩小h的范围，此时small+1，然后继续二分搜索。
 * 如果small都大于big还没有得到h，则返回0；
 */
public class Q274 {
	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return citations.length;
		if (citations.length == 1) {
			if (citations[0] == 0)
				return 0;
			else
				return 1;
		}
		Arrays.sort(citations);
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
