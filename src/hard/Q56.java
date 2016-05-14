package hard;

import java.util.*;
import basicDataStructure.*;
/*
 * 2016.5.14
 * ������Ǻϲ���϶
 * ʹ��һ��TreeSet�ṹ��������һ��comparator���������������϶a��b�����b�Ŀ�ʼ��a�ĺ�����b<a����֮��b>a�����a��b�Ŀ�ʼ��ȣ����Ƚ����Ľ�С��
 * �����п�϶��ӵ�treeset�ṹ�У�ʹ������������϶һ��������ϵ�����ڵġ�
 * �ϲ��������ǣ������Ѿ���������ϲ��Ŀ�϶һ�����Ѿ��ϲ��Ŀ�϶֮��
 * ����������ϲ��Ŀ�϶�Ŀ�ʼ�ھɵĿ�϶֮�ڣ��򽫾ɵĿ�϶�ʹ��ϲ��Ŀ�϶���кϲ���
 * ���򣬽��ɵĿ�϶д���������ϲ��Ŀ�϶��ɾɵĿ�϶��
 */
public class Q56 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0 || intervals.size() == 1)
			return intervals;
		TreeSet<Interval> tset = new TreeSet<Interval>(new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				if (Integer.compare(a.start, b.start) != 0) {
					return Integer.compare(a.start, b.start);
				} else
					return Integer.compare(a.end, b.end);
			}
		});
		Iterator<Interval> iter = intervals.iterator();
		while (iter.hasNext()) {
			tset.add((Interval) iter.next());
		}
		Iterator<Interval> it = tset.iterator();
		int num = 0;
		Interval old = new Interval();
		while (it.hasNext()) {
			if (num == 0) {
				old = (Interval) it.next();
				num++;
				continue;
			}
			Interval temp = (Interval) it.next();
			if ((temp.start >= old.start && temp.start <= old.end)) {
				old = new Interval(Math.min(temp.start, old.start), Math.max(temp.end, old.end));
			} else {
				res.add(old);
				old = temp;
			}
		}
		res.add(old);
		return res;
	}
}
