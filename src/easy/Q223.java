package easy;

/*
 * 2016.7.18
 * ���˺þá���һֱû�кõ�˼·��
 * �ж�����Բ�ཻ����Ŀ����������
 * ����һ�����Σ���ƽ���������ᣩ�����Դ��ĸ�ά�������㣬�������ҡ��ֿ�������һ�����������ĸ�ά�ȵ������Ȼ����ϱ����������ɡ�
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
