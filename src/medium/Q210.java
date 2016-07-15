package medium;

import java.util.*;

/*
 * 2016.7.15
 * 还是基于深度优先搜索的拓扑排序。由于是在遍历完一个节点所有子节点才加入的排序列表，所以使用逆序输出的方式。
 * 和Q207检测有向图是否有环的方法一模一样。
 */
public class Q210 {
	boolean[] marked;
	int[] result;
	Stack<Integer> stack;
	boolean[] onStack;
	boolean cycle = false;
	int count;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		marked = new boolean[numCourses];
		result = new int[numCourses];
		onStack = new boolean[numCourses];
		count = numCourses - 1;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		int m = prerequisites.length;
		if (m == 0) {
			for (int i = 0; i < numCourses; i++) {
				result[i] = i;
			}
			return result;
		}
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
		}
		for (int i = 0; i < m; i++) {
			map.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!marked[i])
				dfs(map, i);
			if (this.hasCycle())
				return new int[0];
		}
		return result;

	}

	public boolean hasCycle() {
		return cycle;
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
				dfs(map, w);
			} else if (onStack[w]) {
				cycle = true;
			}
		}
		result[count] = v;
		count--;
		onStack[v] = false;
	}

}
