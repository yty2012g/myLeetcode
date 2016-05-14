package medium;

/*
 * 2016.5.14
 * ��ǰ���Ǹ������ʵ�ַ�ʽ��һ���ģ�ÿ����hang��lie��������������ÿ��������ٸ���ÿ���һ�У�hang-1��ÿ���һ�У�lie-1
 * 
 */
public class Q59 {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		if (n == 0)
			return res;
		int hang = n;
		int lie = n;
		int cur = 1;
		int way = 1;
		int startX = 0;
		int startY = 0;
		while (cur <= n * n) {
			switch (way) {
			case 1:
				for (int i = startY; i < startY + lie; i++) {
					res[startX][i] = cur;
					cur++;
				}
				hang--;
				startX++;
				startY = startY + lie - 1;
				way = 2;
				break;
			case 2:
				for (int i = startX; i < startX + hang; i++) {
					res[i][startY] = cur;
					cur++;
				}
				lie--;
				startY--;
				startX = startX + hang - 1;
				way = 3;
				break;
			case 3:
				for (int i = startY; i > startY - lie; i--) {
					res[startX][i] = cur;
					cur++;
				}
				hang--;
				startX--;
				startY = startY - lie + 1;
				way = 4;
				break;
			case 4:
				for (int i = startX; i < startX - hang; i--) {
					res[i][startY] = cur;
					cur++;
				}
				lie--;
				startY++;
				startX = startX - hang + 1;
				way = 1;
				break;
			}
		}
		return res;
	}
}
