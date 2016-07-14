package medium;

import java.util.*;

/*
 * 2016.7.14
 * 深度优先搜索判断有向图是否有环。
 * marked数组表示节点是否被访问过
 * onStack数组代表方法栈中包含的节点。
 * edgtTo数组用来记录本次方法栈中的有向边。
 * 第零步。从第一个点开始遍历，如果该点没有被访问过，则开始dfs。
 * 第一步，将onStack设置为true，marked设置为true；
 * 第二步，开始遍历所有从该点出发的边。如果已经有环了，则退出。
 * 第三步，如果某个点没有被访问过，在edgeTo中添加一条有向边，然后深度优先，进入该点继续dfs
 * 第四步，如果第三步中该点已经被访问过了，并且该点还在本次方法栈中，则出现了环。通过不断查找edgeTo，将环补充完整。
 * 返回第零步，如果出现环，则返回false；否则全部结束返回true；
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
