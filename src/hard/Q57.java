package hard;

import java.util.*;
import basicDataStructure.*;

/*
 * 2016.5.14
 * 和Q56不同，这里的就有的间隔list是有序的，因此只要找到待放置的间隔应该在的位置，然后进行间隔的合并即可
 * 条件1：如果待放置的间隔的开始大于当前间隔的结束，则直接将当前间隔放置在结果中，继续遍历
 * 条件2：如果待放置的间隔的开始在当前间隔中或者结束在当前间隔中或者当前间隔在待放置的间隔内部，则开始合并当前间隔和待放置的间隔。并将新的间隔记为old
 * 条件3：如果待放置的间隔的结束小于当前间隔的开始，则如果没有进行合并，就先放待放置的间隔，再放当前结果。
 * 如果进行过合并，则先放置old间隔，在放当前间隔。
 * 如果已经放过待放置的间隔，则直接将当前间隔放置结果集即可。
 */
public class Q57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}
		boolean startF = true;
		boolean endF = true;
		Interval old = new Interval();
		for (int i = 0; i < intervals.size(); i++) {
			if (newInterval.start > intervals.get(i).end) {
				res.add(intervals.get(i));
			} else if ((newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end)
					|| (newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end)
					|| (newInterval.start <= intervals.get(i).start && newInterval.end >= intervals.get(i).end)) {
				if (startF) {
					startF = false;
					old = new Interval(Math.min(newInterval.start, intervals.get(i).start),
							Math.max(newInterval.end, intervals.get(i).end));
				} else {
					old = new Interval(Math.min(old.start, intervals.get(i).start),
							Math.max(old.end, intervals.get(i).end));
				}
			} else {
				if (endF) {
					if (startF)
						res.add(newInterval);
					else
						res.add(old);
					res.add(intervals.get(i));
					endF = false;
				} else {
					res.add(intervals.get(i));
				}
			}
		}
		if (!startF && endF)
			res.add(old);
		if (startF && endF)
			res.add(newInterval);
		return res;
	}

}
