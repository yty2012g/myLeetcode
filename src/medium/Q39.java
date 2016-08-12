package medium;

import java.util.*;

/*
 * 2016.5.9
 * 要点1，由于需要的是不重复的结果，所以要用hashset保证不重复
 * 要点2，candidates一定要是非降序的,所以在前面先调用sort，把candidates排序
 * 要点3，每一个结果最好也要排序，否则由于可以重复使用的关系会导致相同的结果由于顺序不同变成了不同的结果
 * 方法倒是很简单，find的四个参数，第一个就是所有的可以选择的数字，第二个代表目前已经选择的数字
 * 第三个代表目前的总和，第四个代表目标。
 */

/*
 * 2016.8.12
 * 更新一下，还是使用回溯法，代码简单一点，时间稍微快一点，但是还是不是很理想
 */
public class Q39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		combinationSum(candidates, target, new ArrayList<Integer>());
		return new ArrayList<List<Integer>>(hashset);
	}

	public void combinationSum(int[] candidates, int target, ArrayList<Integer> list) {
		for (int i = 0; i < candidates.length; i++) {
			int temp = target - candidates[i];
			if (temp < 0) {
				return;
			} else if (temp == 0) {
				ArrayList<Integer> copy = (ArrayList<Integer>) list.clone();
				copy.add(candidates[i]);
				Collections.sort(copy);
				hashset.add(copy);
			} else {
				ArrayList<Integer> copy = (ArrayList<Integer>) list.clone();
				copy.add(candidates[i]);
				combinationSum(candidates, temp, copy);
			}
		}
		return;
	}

	HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<Integer> array = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < candidates.length; i++) {
			if (!set.contains(candidates[i])) {
				array.add(candidates[i]);
				set.add(candidates[i]);
			}
		}
		ArrayList<Integer> cur = new ArrayList<Integer>();
		find(array, cur, 0, target);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Iterator iter = hashset.iterator();
		while (iter.hasNext()) {
			res.add((List<Integer>) iter.next());
		}
		return res;
	}

	public void find(ArrayList<Integer> source, ArrayList<Integer> cur, int cursum, int sum) {
		ArrayList<Integer> c = new ArrayList<Integer>();

		if (sum - cursum < source.get(0))
			return;
		for (int i = 0; i < source.size(); i++) {
			if (source.get(i) > sum - cursum)
				break;
			else {
				c = (ArrayList<Integer>) cur.clone();
				cursum = cursum + source.get(i);
				c.add(source.get(i));
				if (cursum == sum) {
					Collections.sort(c);
					hashset.add(c);
					break;
				} else {
					find(source, c, cursum, sum);
				}
			}
			cursum = cursum - source.get(i);
		}
	}
}
