package medium;

import java.util.*;

/*
 * 2017.5.9
 * 这里使用了字典序全排列算法，非递归形式。
 * 找到一个序列的下一个字典序分为四个步骤。
 * 第一步，从最后往前扫描，如果在第i个位置符合第i个位置的元素大于第i-1个位置的元素，则记录第i-1个元素的下标为indexA
 * 第二步，从第i个位置向后扫描，找到最后一个大于第i-1个元素的元素，位置记录为indexB
 * 第三步，将第indexA个元素和第indexB个元素交换
 * 第四步，将indexA位置以后的元素反序。
 * 
 * 注意，如果indexA和indexB都为0，则表明序列是递减的，因此只要全部反序即可。
 */
public class Q31 {
	public void nextPermutation(int[] nums) {
		int indexA = 0;
		int indexB = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				indexA = i - 1;
				for (int j = i; j < nums.length; j++) {
					if (nums[j] > nums[indexA])
						indexB = j;
				}
				int temp = nums[indexA];
				nums[indexA] = nums[indexB];
				nums[indexB] = temp;
				reverse(nums, indexA + 1);
				break;
			}
		}
		if (indexA == 0 && indexB == 0) {
			reverse(nums, 0);
		}
	}

	public void reverse(int[] nums, int start) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = start; i < nums.length; i++) {
			stack.push(nums[i]);
		}
		for (int i = start; i < nums.length; i++) {
			nums[i] = stack.pop();
		}
	}
}
