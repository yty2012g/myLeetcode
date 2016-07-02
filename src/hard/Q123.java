package hard;

import java.util.*;

public class Q123 {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;
		LinkedList<ArrayList<Integer>> res = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int m1 = 0;
		int m2 = 0;
		int min = 0;
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[min])
				min = i;
			max = Math.max(max, prices[i] - prices[min]);
			if (prices[i] >= prices[i - 1]) {
				if (temp.size() == 0) {
					temp.add(prices[i - 1]);
					if (i == prices.length - 1) {
						temp.add(prices[i]);
						temp.add(temp.get(1) - temp.get(0));
						add(temp, res);
					}
				} else if (temp.size() == 1) {
					temp.add(prices[i]);
					if (i == prices.length - 1) {
						temp.add(temp.get(1) - temp.get(0));
						add(temp, res);
					}
				} else {
					temp.set(1, prices[i - 1]);
					if (i == prices.length - 1) {
						temp.set(1, prices[i]);
						temp.add(temp.get(1) - temp.get(0));
						add(temp, res);
					}
				}
			} else {
				if (temp.size() == 0)
					continue;
				else if (temp.size() == 1) {
					temp.add(prices[i - 1]);
					temp.add(temp.get(1) - temp.get(0));
				} else {
					temp.add(temp.get(1) - temp.get(0));
				}
				add(temp, res);
				temp = new ArrayList<Integer>();
			}
		}
		System.out.println(res);
		if (res.size() == 0)
			return 0;
		else if (res.size() == 1)
			return max;
		else if (res.size() == 2)
			return Math.max(max, res.get(0).get(2) + res.get(1).get(2));
		else {
			Iterator<ArrayList<Integer>> iter = res.iterator();
			while (iter.hasNext()) {
				ArrayList<Integer> t = iter.next();
				if (t.get(2) >= m1) {
					m2 = m1;
					m1 = t.get(2);
				} else if (t.get(2) >= m2 && t.get(2) < m1) {
					m2 = t.get(2);
				}
			}
		}
		return Math.max(max, m1 + m2);
	}

	public void add(ArrayList<Integer> temp, LinkedList<ArrayList<Integer>> res) {

		if (res.size() == 0) {
			res.add(temp);
		} else {
			ArrayList<Integer> last = res.get(res.size() - 1);
			System.out.println(last);
			while (last.get(0) <= temp.get(0) && last.get(1) <= temp.get(1)
					&& (temp.get(1) - last.get(0) > temp.get(2) + last.get(2))) {
				res.remove(last);
				temp.set(0, last.get(0));
				temp.set(2, temp.get(1) - temp.get(0));
				if (res.size() == 0)
					break;
				last = res.get(res.size() - 1);
			}
			res.add(temp);
		}
	}
}
