package hard;

import basicDataStructure.Point;
import java.util.*;

/*
 * 2016.7.6
 * д��һ��Line�ڲ������һ���ߡ��Ӽ򵥵���ѧ֪ʶ��֪����άƽ����߾�����ax+by+c=0��ʾ��һ����ԣ��Ǵ�ֱ����������߿���y=ax+b��ʾ
 * ��ˣ�������������Եõ�һ��ֱ�ߣ���Ϊ4�������
 * 1.һ����
 * 2.��ֱ��x�ᣬ��x=...;
 * 3.��ֱ��y�ᣬ��y=...;
 * 4.����������ͬ�ġ�
 * ��Line���У�flag�������ͣ�a��b���������������������Եõ�һ��Line����
 * ���hashmap���ؼ�����Line���hashcode������equals������equals�����ܼ򵥣�ֻҪa��b��flag��ͬ���ɡ�
 * hashcode������������õ��ǽ�����������hashֵ��ӵõ��������ڱ�֤���ܵ�ǰ���£������ܼ�����ײ��
 */
public class Q149 {
	public class Line {
		double a = 0;
		double b = 0;
		int flag = 0;

		public Line(Point a, Point b) {
			if (a.x != b.x && a.y != b.y) {
				this.a = (double)(a.y - b.y) / (a.x - b.x);
				this.b = (double)(a.x * b.y - a.y * b.x) / (a.x - b.x);
				if (this.b == -0.0)
					this.b = 0.0;
				this.flag = 1;
			} else if (a.x == b.x && a.y != b.y) {
				this.a = a.x;
				this.flag = 2;
			} else if (a.x != b.x && a.y == b.y) {
				this.b = a.y;
				this.flag = 3;
			} else {
				this.flag = 4;
				this.a = a.x;
				this.b = a.y;
			}
		}
		@Override
		public int hashCode() {
			Double aa=this.a;
			Double bb=this.b;
			Integer ff=this.flag;
			return aa.hashCode()+bb.hashCode()+ff.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			Line line = (Line) obj;
			if (this.a == line.a && this.b == line.b && this.flag == line.flag)
				return true;
			else
				return false;

		}
	}

	public int maxPoints(Point[] points) {
		int max = 0;
		if (points.length == 0 || points.length == 1 || points.length == 2)
			return points.length;
		HashMap<Line, HashSet<Point>> map = new HashMap<Line, HashSet<Point>>();
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line line = new Line(points[i], points[j]);
				if (map.containsKey(line)) {
					map.get(line).add(points[i]);
					map.get(line).add(points[j]);
				} else {
					HashSet<Point> hashset = new HashSet<Point>();
					hashset.add(points[i]);
					hashset.add(points[j]);
					map.put(line, hashset);
				}
				max=Math.max(max, map.get(line).size());
			}
		}
		return max;
	}
}
