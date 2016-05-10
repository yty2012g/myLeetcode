package medium;

import java.util.*;
/*
 * 2016.5.10
 * ��q46��ͬ���ǣ����������ظ���Ԫ�أ���˾Ͳ�����q46һ�������ȫ���е�������
 * ����ʹ��whileѭ������ֹ�������ǻص�ԭ�����Ǹ����顣
 * 8ms
 */

public class Q47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> basic = new ArrayList<Integer>();
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i = 1; i <= nums.length; i++) {
			array.add(nums[i - 1]);
			basic.add(nums[i - 1]);
		}
		while (!copy.equals(basic)) {
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
