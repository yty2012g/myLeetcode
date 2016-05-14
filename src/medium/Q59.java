package medium;

/*
 * 2016.5.14
 * 和前面那个输出的实现方式是一样的，每次用hang和lie两个变量来控制每次输出多少个，每输出一行，hang-1，每输出一列，lie-1
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
