package medium;

import java.util.*;
import basicDataStructure.UndirectedGraphNode;

/*
 * 2016.7.4
 * �����Ŀ��������һ������ͼ�������Ŀ���������裺��һ��ÿһ���ڵ�ı�ǩ����Ψһ�ġ��ڶ������нڵ㶼�ǿɴ�ģ���û�й����ڵ㡣
 * �����������裬Ӧ�ù������������
 * ʹ��һ��HashMap��¼�Ѿ����ɵĽڵ㡣�������һ���ڵ������ȴû�д���ʱ����neibor�б�ĳ���Ϊ0�����ݼ���2��֪��
 * ���ԣ�ÿ����һ���ڵ㣬���ȸ���Դ�ڵ��label����hashmap�����Ƿ��Ѿ������˶�Ӧ�Ľڵ㡣���û�о����ɣ�����о�ȡ������ڵ㡣��������ڵ��Ѿ�����ͬʱneibor�б�ĳ��Ⱥ�Դһ�£��Ͳ���Ҫ�ڴ����ˡ�
 * ����neibor�б�����ÿһ��neibor�����neibor�Ѿ����ɣ���ֱ�Ӽ��뵱ǰ����ڵ��neibor�б����������ɣ��ټ��롣
 * Ȼ��ѵ�ǰ�����neibor���봦������С�
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
