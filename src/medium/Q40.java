package medium;

import java.util.*;
/*
 * 2016.5.9
 * 这道题和Q39非常相似，不同点是每个元素只可以使用一次。
 * 对于q39而言，重复的元素是没有意义的，因为每个元素可以用无数次，所以在一开始进行去重的操作
 * 但是对于q40而言，由于每个元素最多只能使用一次，所以不需要去重。
 * 第二，需要一个times的ArrayList，用来记录那个元素被选用过了，如果用过了，则直接跳过。
 * 对于java而言，这两道题都需要注意的点是，java.util下面的类，都是引用传递，所以对于每一次递归，需要考虑当前修改对前面和后面的影响
 * 最好使用一个clone的拷贝版本。
 */
public class Q40 {
	HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<Integer> array = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < candidates.length; i++) {
			array.add(candidates[i]);
		}
		System.out.println(target);
		ArrayList<Integer> cur = new ArrayList<Integer>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		find(array, cur, times, 0, target);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Iterator iter = hashset.iterator();
		while (iter.hasNext()) {
			res.add((List<Integer>) iter.next());
		}
		return res;
	}

	public void find(ArrayList<Integer> source, ArrayList<Integer> cur, ArrayList<Integer> times, int cursum, int sum) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		if (sum - cursum < source.get(0))
			return;
		for (int i = 0; i < source.size(); i++) {
			if (source.get(i) > sum - cursum)
				break;
			else if (!times.contains(i)) {
				c = (ArrayList<Integer>) cur.clone();
				t = (ArrayList<Integer>) times.clone();
				t.add(i);
				c.add(source.get(i));
				if (cursum + source.get(i) == sum) {
					Collections.sort(c);
					hashset.add(c);
					break;
				} else {
					find(source, c, t, cursum + source.get(i), sum);
				}
			}

		}
	}
}
