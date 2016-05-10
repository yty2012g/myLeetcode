package medium;

import java.util.*;

/*
 * 2016.5.10
 * 按照字典序生成全排序算法，题目中提到没有重复的数字，还是分成四个步骤
 * 第一，从后往前找，找到第i个元素使得第i个元素大于第i-1个元素，记录index为i-1；
 * 第二，从index+1个元素开始找，找到最后一个比第index个元素大的元素，下标记为indexB
 * 第三，如果indexA和indexB同时为0，说明当前序列为递减序列，因此全部反序就是下一个序列。
 * 第四，将下标为indexA和indexB的元素交换，将下标从indexA+1到结尾的元素反序就是下一个序列。
 * 
 * 这里在将数组转换成arraylist的过程中就计算了全排列的数量，记为num
 */
public class Q46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int num = 1;
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i = 1; i <= nums.length; i++) {
			num = num * i;
			array.add(nums[i - 1]);
		}
		for (int i = 1; i <= num; i++) {
			int indexA = 0;
			int indexB = 0;
			for (int j = nums.length - 1; j > 0; j--) {
				if (array.get(j) > array.get(j - 1)) {
					indexA = j - 1;
					break;
				}
			}
			for (int k = indexA + 1; k < nums.length; k++) {
				if (array.get(k) > array.get(indexA))
					indexB = k;
			}

			if (indexA == 0 && indexB == 0) {
				reverse(array, 0);
			} else {
				int temp = array.get(indexA);
				array.set(indexA, array.get(indexB));
				array.set(indexB, temp);
				reverse(array, indexA + 1);
			}
			copy = (ArrayList<Integer>) array.clone();
			res.add(copy);
		}
		return res;
	}

	public void reverse(ArrayList<Integer> array, int start) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = start; i < array.size(); i++) {
			stack.push(array.get(i));
		}
		for (int i = start; i < array.size(); i++) {
			array.set(i, stack.pop());
		}
	}
}
