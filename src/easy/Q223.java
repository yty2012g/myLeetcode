package easy;

/*
 * 2016.7.18
 * 想了好久。。一直没有好的思路。
 * 判断两个圆相交的题目给予启发。
 * 对于一个矩形（边平行于坐标轴），可以从四个维度来计算，上下左右。分开计算另一个矩形在这四个维度的面积，然后加上本身的面积即可。
 */
public class Q223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int s = (D - B) * (C - A);
		if (E < A) {
			s = s + (Math.min(A, G) - E) * (H - F);
		}
		if (G > C) {
			s = s + (G - Math.max(C, E)) * (H - F);
		}
		if (H > D) {
			if (E >= A && G <= C) {
				s = s + (G - E) * (H - Math.max(D, F));
			}
			if (E < A && G > A) {
				if (G <= C)
					s = s + (G - A) * (H - Math.max(D, F));
				if (G > C)
					s = s + (C - A) * (H - Math.max(D, F));
			}
			if (E >= A && E < C && G > C) {
				s = s + (C - E) * (H - Math.max(D, F));
			}
		}
		if (F < B) {
			if (E >= A && G <= C) {
				s = s + (G - E) * (Math.min(B, H) - F);
			}
			if (E < A && G > A) {
				if (G <= C)
					s = s + (G - A) * (Math.min(B, H) - F);
				if (G > C)
					s = s + (C - A) * (Math.min(B, H) - F);
			}
			if (E >= A && E < C && G > C) {
				s = s + (C - E) * (Math.min(B, H) - F);
			}
		}
		return s;
	}
}
