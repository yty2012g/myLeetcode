package hard;

import java.util.*;
/*
 * 2016.5.14
 * n皇后问题使用回溯法，有几个辅助的函数
 * solveNQueens方法，名义上的主方法，实际的工作是进行初始化工作
 * test方法，实际的主方法，参数row代表当前处理到第几行。对于该行的每一列进行扫描，满足当前列没有皇后，左斜线没有皇后，右斜线没有皇后
 * 满足条件后，放置皇后，并且将上述条件改变，进行下一行的递归。如果每一列都不满足条件，则回溯到上一行，并且将这一行放置的皇后取消
 * 
 * getRes和get方法目的就是打印，没什么说的。
 */
public class Q51 {
	boolean[] colExist;
	boolean[] leftHighExist;
	boolean[] rightHighExist;
	ArrayList<ArrayList<Integer>> position;
	ArrayList<Integer> queens = new ArrayList<Integer>();

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(n<=3) return res;
		for (int i = 0; i < n; i++) {
			queens.add(-1);
		}
		position = new ArrayList<ArrayList<Integer>>();
		colExist = new boolean[n];//当前列有没有皇后
		leftHighExist = new boolean[2 * n - 1];//左高右低的斜线有没有皇后
		rightHighExist = new boolean[2 * n - 1];//左低右高的斜线有没有皇后。
		for (int i = 0; i < n; i++) {
			colExist[i] = false;
			leftHighExist[i] = false;
			leftHighExist[i + n - 1] = false;
			rightHighExist[i] = false;
			rightHighExist[i + n - 1] = false;
		}
		test(0, n);
		return getRes(position, n);
	}

	public void test(int row, int n) {
		for (int col = 0; col < n; col++) {
			if (!exist(row, col, n)) {
				queens.set(row, col);
				colExist[col] = leftHighExist[row - col + n - 1] = rightHighExist[row + col] = true;
				if (row == n - 1) {//如果到了最后一行，仍然满足条件，就将当前的所有皇后位置记录下来。
					ArrayList<Integer> copy = (ArrayList<Integer>) queens.clone();
					position.add(copy);
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

	public List<List<String>> getRes(ArrayList<ArrayList<Integer>> position, int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		Iterator iter = position.iterator();
		while (iter.hasNext()) {
			res.add(get((ArrayList<Integer>) iter.next(), n));
		}
		return res;
	}

	public ArrayList<String> get(ArrayList<Integer> queen, int n) {
		ArrayList<String> res = new ArrayList<String>();
		char[] temp = new char[n];
		for (int i = 0; i < n; i++) {
			temp[i] = '.';
		}
		char[] copy = new char[n];
		for (int i = 0; i < n; i++) {
			copy = temp.clone();
			int col = queen.get(i);
			copy[col] = 'Q';
			String middle = "";
			for (int j = 0; j < n; j++) {
				middle = middle + copy[j];
			}
			res.add(middle);
		}
		return res;
	}
}
