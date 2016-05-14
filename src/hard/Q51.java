package hard;

import java.util.*;
/*
 * 2016.5.14
 * n�ʺ�����ʹ�û��ݷ����м��������ĺ���
 * solveNQueens�����������ϵ���������ʵ�ʵĹ����ǽ��г�ʼ������
 * test������ʵ�ʵ�������������row����ǰ�����ڼ��С����ڸ��е�ÿһ�н���ɨ�裬���㵱ǰ��û�лʺ���б��û�лʺ���б��û�лʺ�
 * ���������󣬷��ûʺ󣬲��ҽ����������ı䣬������һ�еĵݹ顣���ÿһ�ж�����������������ݵ���һ�У����ҽ���һ�з��õĻʺ�ȡ��
 * 
 * getRes��get����Ŀ�ľ��Ǵ�ӡ��ûʲô˵�ġ�
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
		colExist = new boolean[n];//��ǰ����û�лʺ�
		leftHighExist = new boolean[2 * n - 1];//����ҵ͵�б����û�лʺ�
		rightHighExist = new boolean[2 * n - 1];//����Ҹߵ�б����û�лʺ�
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
				if (row == n - 1) {//����������һ�У���Ȼ�����������ͽ���ǰ�����лʺ�λ�ü�¼������
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
