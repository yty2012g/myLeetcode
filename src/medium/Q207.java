package medium;

import java.util.*;

/*
 * 2016.7.14
 * ������������ж�����ͼ�Ƿ��л���
 * marked�����ʾ�ڵ��Ƿ񱻷��ʹ�
 * onStack���������ջ�а����Ľڵ㡣
 * edgtTo����������¼���η���ջ�е�����ߡ�
 * ���㲽���ӵ�һ���㿪ʼ����������õ�û�б����ʹ�����ʼdfs��
 * ��һ������onStack����Ϊtrue��marked����Ϊtrue��
 * �ڶ�������ʼ�������дӸõ�����ıߡ�����Ѿ��л��ˣ����˳���
 * �����������ĳ����û�б����ʹ�����edgeTo�����һ������ߣ�Ȼ��������ȣ�����õ����dfs
 * ���Ĳ�������������иõ��Ѿ������ʹ��ˣ����Ҹõ㻹�ڱ��η���ջ�У�������˻���ͨ�����ϲ���edgeTo����������������
 * ���ص��㲽��������ֻ����򷵻�false������ȫ����������true��
 */
public class Q207 {
	boolean[] marked;
	int[] edgeTo;
	Stack<Integer> stack;
	boolean[] onStack;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		marked = new boolean[numCourses];
		edgeTo = new int[numCourses];
		onStack = new boolean[numCourses];
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		int m = prerequisites.length;
		if (m == 0)
			return true;
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
		}
		for (int i = 0; i < m; i++) {
			map.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!marked[i])
				dfs(map, i);
			if (this.hasCycle())
				return false;
		}
		return true;

	}

	public boolean hasCycle() {
		return stack != null;
	}

	public void dfs(HashMap<Integer, HashSet<Integer>> map, int v) {
		onStack[v] = true;
		marked[v] = true;
		Iterator<Integer> iter = map.get(v).iterator();
		while (iter.hasNext()) {
			int w = iter.next();
			if (this.hasCycle())
				return;
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(map, w);
			} else if (onStack[w]) {
				stack = new Stack<Integer>();
				for (int i = v; i != w; i = edgeTo[i]) {
					stack.push(i);
				}
				stack.push(w);
				stack.push(v);
			}
		}
		onStack[v] = false;
	}
}
