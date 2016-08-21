package hard;

import java.util.*;

import basicDataStructure.Interval;

/*
 * 2016.8.21
 * ʹ��һ��list����¼���е�interval��������ÿ��add������Ҫ���������״̬��
 * add���������listΪ�գ�ֱ������µ�interval��
 *          ���list�ǿգ�ʹ��binarySearch���ҵ���һ���ȴ�����interval���pos��
 *          ���posΪ����˵���Ѿ������ֵ�ˣ�����Ҫ����������
 *          ���posΪ��������������λ����0����͵�0��Ԫ�رȽϣ�������Ժϲ����ͺϲ������򣬽���ǰԪ�ز����0λ�á�
 *                       ����������λ����size��������һ��Ԫ�رȽϣ�������Ժϲ��ͺϲ�������ֱ����������
 *                       ���������λ�ã���Ҫ��ǰ������Ԫ�ؽ��бȽϣ���������ܺϲ�������ӵ�indexλ�ã�������кϲ�������
 *                       ע�⣬������Ժ�ǰһ��Ԫ�غϲ���Ҳ��Ҫ���ϲ����ǰһ��Ԫ���ܲ��ܺͺ�һ��Ԫ�غϲ���
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
