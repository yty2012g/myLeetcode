package hard;

import java.util.*;

/*
 * 2016.5.14
 * 和Q51方法一样，只需要返回解的数量即可。
 */
public class Q52 {
	boolean[] colExist;
	boolean[] leftHighExist;
	boolean[] rightHighExist;
	int position = 0;
	ArrayList<Integer> queens = new ArrayList<Integer>();

	public int totalNQueens(int n) {
		if (n < 1 || n == 2 || n == 3)
			return 0;
		for (int i = 0; i < n; i++) {
			queens.add(-1);
		}
		colExist = new boolean[n];// 当前列有没有皇后
		leftHighExist = new boolean[2 * n - 1];// 左高右低的斜线有没有皇后
		rightHighExist = new boolean[2 * n - 1];// 左低右高的斜线有没有皇后。
		for (int i = 0; i < n; i++) {
			colExist[i] = false;
			leftHighExist[i] = false;
			leftHighExist[i + n - 1] = false;
			rightHighExist[i] = false;
			rightHighExist[i + n - 1] = false;
		}
		test(0, n);
		return position;
	}

	public void test(int row, int n) {
		for (int col = 0; col < n; col++) {
			if (!exist(row, col, n)) {
				colExist[col] = leftHighExist[row - col + n - 1] = rightHighExist[row + col] = true;
				if (row == n - 1) {// 如果到了最后一行，仍然满足条件，就将当前的所有皇后位置记录下来。
					position++;
					colExist[col] = leftHighExist[row - col + n - 1] = rightHighExist[row + col] = false;
					return;
				} else {
					test(row + 1, n);
				}
				colExist[col] = leftHighExist[row - col + n - 1] = rightHighExist[row + col] = false;
			}
		}
	}

	public boolean exist(int row, int col, int n) {
		return colExist[col] || leftHighExist[row - col + n - 1] || rightHighExist[row + col];
	}
}
