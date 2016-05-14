package hard;

import java.util.*;
import basicDataStructure.*;

/*
 * 2016.5.14
 * ��Q56��ͬ������ľ��еļ��list������ģ����ֻҪ�ҵ������õļ��Ӧ���ڵ�λ�ã�Ȼ����м���ĺϲ�����
 * ����1����������õļ���Ŀ�ʼ���ڵ�ǰ����Ľ�������ֱ�ӽ���ǰ��������ڽ���У���������
 * ����2����������õļ���Ŀ�ʼ�ڵ�ǰ����л��߽����ڵ�ǰ����л��ߵ�ǰ����ڴ����õļ���ڲ�����ʼ�ϲ���ǰ����ʹ����õļ���������µļ����Ϊold
 * ����3����������õļ���Ľ���С�ڵ�ǰ����Ŀ�ʼ�������û�н��кϲ������ȷŴ����õļ�����ٷŵ�ǰ�����
 * ������й��ϲ������ȷ���old������ڷŵ�ǰ�����
 * ����Ѿ��Ź������õļ������ֱ�ӽ���ǰ������ý�������ɡ�
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
