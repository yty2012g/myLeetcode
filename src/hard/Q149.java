package hard;

import basicDataStructure.Point;
import java.util.*;

/*
 * 2016.7.6
 * 写了一个Line内部类代表一条线。从简单的数学知识可知，二维平面的线均可由ax+by+c=0表示，一般而言，非垂直于坐标轴的线可有y=ax+b表示
 * 因此，给定两个点可以得到一条直线，分为4种情况。
 * 1.一般线
 * 2.垂直于x轴，即x=...;
 * 3.垂直于y轴，即y=...;
 * 4.两个点是相同的。
 * 在Line类中，flag代表类型，a和b代表参数。根据两个点可以得到一个Line对象。
 * 结合hashmap，关键点是Line类的hashcode方法和equals方法。equals方法很简单，只要a，b和flag相同即可。
 * hashcode方法，这里采用的是将三个参数的hash值相加得到。可以在保证性能的前提下，尽可能减少碰撞。
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
