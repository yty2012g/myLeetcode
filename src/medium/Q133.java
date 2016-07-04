package medium;

import java.util.*;
import basicDataStructure.UndirectedGraphNode;

/*
 * 2016.7.4
 * 这道题目是来拷贝一个无向图。这道题目有两个假设：第一，每一个节点的标签都是唯一的。第二，所有节点都是可达的，即没有孤立节点。
 * 根据两个假设，应用广度优先搜索。
 * 使用一个HashMap记录已经生成的节点。但是如果一个节点仅生成却没有处理时，其neibor列表的长度为0，根据假设2可知。
 * 所以，每处理一个节点，首先根据源节点的label，从hashmap中找是否已经生成了对应的节点。如果没有就生成，如果有就取出这个节点。此外如果节点已经生成同时neibor列表的长度和源一致，就不需要在处理了。
 * 对于neibor列表，其中每一个neibor，如果neibor已经生成，就直接加入当前处理节点的neibor列表。否则先生成，再加入。
 * 然后把当前处理的neibor加入处理队列中。
 */
public class Q133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode temp = queue.poll();
			UndirectedGraphNode cur = new UndirectedGraphNode(0);
			if (map.containsKey(temp.label)) {
				cur = map.get(temp.label);
				if (cur.neighbors.size() != 0)
					continue;
			} else {
				cur = new UndirectedGraphNode(temp.label);
				map.put(cur.label, cur);
			}
			Iterator<UndirectedGraphNode> iter = temp.neighbors.iterator();
			while (iter.hasNext()) {
				UndirectedGraphNode neibor = iter.next();
				UndirectedGraphNode curneibor = new UndirectedGraphNode(0);
				if (map.containsKey(neibor.label)) {
					curneibor = map.get(neibor.label);
				} else {
					curneibor = new UndirectedGraphNode(neibor.label);
					map.put(neibor.label, curneibor);
				}
				cur.neighbors.add(curneibor);
				if (curneibor.neighbors.size() != neibor.neighbors.size())
					queue.offer(neibor);
			}
		}
		return map.get(node.label);
	}
}
