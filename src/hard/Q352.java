package hard;

import java.util.*;

import basicDataStructure.Interval;

/*
 * 2016.8.21
 * 使用一个list来记录所有的interval，这里面每次add操作都要保持有序的状态。
 * add操作，如果list为空，直接添加新的interval。
 *          如果list非空，使用binarySearch，找到第一个比待插入interval大的pos。
 *          如果pos为正，说明已经有这个值了，不需要其他操作。
 *          如果pos为负。如果待插入的位置是0，则和第0个元素比较，如果可以合并，就合并，否则，将当前元素插入第0位置。
 *                       如果待插入的位置是size，则和最后一个元素比较，如果可以合并就合并，否则直接添加在最后。
 *                       如果是其他位置，需要和前后两个元素进行比较，如果都不能合并，就添加到index位置，否则进行合并操作。
 *                       注意，如果可以和前一个元素合并，也需要检查合并后的前一个元素能不能和后一个元素合并。
 */
public class Q352 {
	public class SummaryRanges {
		List<Interval> list;
		Comparator<Interval> com;

		/** Initialize your data structure here. */
		public SummaryRanges() {
			list = new ArrayList<Interval>();
			com = new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
					return o1.start - o2.start;
				}
			};
		}

		public void addNum(int val) {
			Interval it = new Interval(val, val);
			if (list.size() == 0) {
				list.add(it);
				return;
			}
			int pos = Collections.binarySearch(list, it, com);
			if (pos < 0) {
				int index = -1 * (pos + 1);
				if (index == 0) {
					if (it.start == list.get(0).start - 1) {
						list.get(0).start = it.start;
					} else if (it.start < list.get(0).start - 1) {
						list.add(0, it);
					}
				} else if (index == list.size()) {
					if (it.start == list.get(index - 1).end + 1) {
						list.get(index - 1).end = it.start;
					} else if (it.start > list.get(index - 1).end + 1) {
						list.add(it);
					}
				} else {
					if (list.get(index - 1).end == it.start - 1) {
						list.get(index - 1).end = it.start;
						if (list.get(index).start == it.start + 1) {
							list.get(index - 1).end = list.get(index).end;
							list.remove(index);
						}
					} else if (list.get(index - 1).end > it.start - 1) {
					} else {
						if (index == list.size()) {
							list.add(it);
						} else {
							if (it.start == list.get(index).start - 1) {
								list.get(index).start = it.start;
							} else if (it.start == list.get(index).start) {

							} else {
								list.add(index, it);
							}
						}

					}
				}

			}
		}

		public List<Interval> getIntervals() {
			return list;
		}
	}
}
