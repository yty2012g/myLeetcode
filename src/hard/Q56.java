package hard;

import java.util.*;
import basicDataStructure.*;
/*
 * 2016.5.14
 * 这道题是合并空隙
 * 使用一个TreeSet结构，并定义一个comparator，如果对于两个空隙a和b，如果b的开始在a的后面则b<a，反之则b>a。如果a和b的开始相等，则先结束的较小。
 * 将所有空隙添加到treeset结构中，使得相邻两个空隙一定是坐标系上相邻的。
 * 合并的条件是：由于已经有序，则待合并的空隙一定在已经合并的空隙之后。
 * 规则：如果待合并的空隙的开始在旧的空隙之内，则将旧的空隙和待合并的空隙进行合并。
 * 否则，将旧的空隙写入结果，待合并的空隙变成旧的空隙。
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
