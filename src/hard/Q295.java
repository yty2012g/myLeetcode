package hard;

import java.util.*;

/*
 * 2016.7.28
 * 这个利用了一个hashmap一个treeset。
 * 使用mid记录中位数，或者中位数的第一个数字，pos记录目前的mid在所有和mid相等的值的位置，size记录set的容量。
 * addNum，如果map存在，则直接把map中对应值出现的次数加一。如果不存在，则出现次数置为1，并且加入treeset中。
 * size自增。
 * 如果num是第一个数，那么中位数自然就是num
 * 否则，如果num大于mid，并且此时数组长度为奇数时，mid为数组位置的下一个。如果pos不等于mid已经出现的次数，说明下一个数字还是mid，否则，就是set中mid的下一个数字。
 * 如果num等于mid，并且数组长度为奇数时，pos移动1位。
 * 如果num小于mid，并且数字长度为偶数时，mid为数组位置的前一个，如果pos不为1，则pos--即可，否则，移动到set表中mid的前一个数字，pos置为map中mid出现的次数。
 */
public class Q295 {
	public class MedianFinder {
		public TreeSet<Integer> set = new TreeSet<Integer>();
		public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(1000);
		public int mid = 0;
		public int pos = 1;
		public int size = 0;

		// Adds a number into the data structure.
		public void addNum(int num) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
				set.add(num);
			}
			size++;
			if (size == 1) {
				mid = num;
			} else {
				if (num > mid) {
					if ((size & 1) == 1) {
						if (pos == map.get(mid)) {
							mid = set.higher(mid);
							pos = 1;
						} else {
							pos++;
						}
					}
				} else if (num == mid) {
					if ((size & 1) == 1) {
						pos++;
					}
				} else {
					if ((size & 1) == 0) {
						if (pos == 1) {
							mid = set.lower(mid);
							pos = map.get(mid);
						} else {
							pos--;
						}
					}
				}
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if ((size & 1) == 0) {
				double a = mid;
				double b = pos == map.get(mid) ? set.higher(mid) : mid;
				return (a + b) / 2;
			} else {
				return mid;
			}
		}
	};
}
