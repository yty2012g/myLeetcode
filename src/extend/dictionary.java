package extend;

import java.util.*;
/*
 * 2016.5.9
 * 字典序全排列算法。
 * 找到一个序列的下一个字典序分为四个步骤。
 * 第一步，从最后往前扫描，如果在第i个位置符合第i个位置的元素大于第i-1个位置的元素，则记录第i-1个元素的下标为index
 * 第二步，从第i个位置向后扫描，找到最后一个大于第i-1个元素的元素，位置记录为indexB
 * 第三步，将第index个元素和第indexB个元素交换
 * 第四步，将index位置以后的元素反序。
 */
public class dictionary {
	public void dic() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		int res = 1;
		for (int i = 1; i <= 5; i++) {
			array.add(i);
			res = res * i;
		}
		for (int i = 1; i <= res; i++) {
			int index = 0;
			int indexB = 0;
			for (int j = array.size() - 1; j > 0; j--) {
				if (array.get(j) > array.get(j - 1)) {
					index = j - 1;
					for (int k = j; k < array.size(); k++) {
						if (array.get(k) > array.get(index))
							indexB = k;
					}
					int temp = array.get(index);
					array.set(index, array.get(indexB));
					array.set(indexB, temp);
					reverse(array, index + 1);
					break;
				}
			}
			System.out.println(array);
		}
	}

	public void reverse(ArrayList<Integer> array, int length) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = length; i < array.size(); i++) {
			stack.push(array.get(i));
		}
		for (int i = length; i < array.size(); i++) {
			array.set(i, stack.pop());
		}
	}
}
