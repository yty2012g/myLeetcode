package hard;

import java.util.*;

/*
 * 2016.7.28
 * ���������һ��hashmapһ��treeset��
 * ʹ��mid��¼��λ����������λ���ĵ�һ�����֣�pos��¼Ŀǰ��mid�����к�mid��ȵ�ֵ��λ�ã�size��¼set��������
 * addNum�����map���ڣ���ֱ�Ӱ�map�ж�Ӧֵ���ֵĴ�����һ����������ڣ�����ִ�����Ϊ1�����Ҽ���treeset�С�
 * size������
 * ���num�ǵ�һ��������ô��λ����Ȼ����num
 * �������num����mid�����Ҵ�ʱ���鳤��Ϊ����ʱ��midΪ����λ�õ���һ�������pos������mid�Ѿ����ֵĴ�����˵����һ�����ֻ���mid�����򣬾���set��mid����һ�����֡�
 * ���num����mid���������鳤��Ϊ����ʱ��pos�ƶ�1λ��
 * ���numС��mid���������ֳ���Ϊż��ʱ��midΪ����λ�õ�ǰһ�������pos��Ϊ1����pos--���ɣ������ƶ���set����mid��ǰһ�����֣�pos��Ϊmap��mid���ֵĴ�����
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
