package medium;

import java.util.*;

/*
 * 2017.5.9
 * ����ʹ�����ֵ���ȫ�����㷨���ǵݹ���ʽ��
 * �ҵ�һ�����е���һ���ֵ����Ϊ�ĸ����衣
 * ��һ�����������ǰɨ�裬����ڵ�i��λ�÷��ϵ�i��λ�õ�Ԫ�ش��ڵ�i-1��λ�õ�Ԫ�أ����¼��i-1��Ԫ�ص��±�ΪindexA
 * �ڶ������ӵ�i��λ�����ɨ�裬�ҵ����һ�����ڵ�i-1��Ԫ�ص�Ԫ�أ�λ�ü�¼ΪindexB
 * ������������indexA��Ԫ�غ͵�indexB��Ԫ�ؽ���
 * ���Ĳ�����indexAλ���Ժ��Ԫ�ط���
 * 
 * ע�⣬���indexA��indexB��Ϊ0������������ǵݼ��ģ����ֻҪȫ�����򼴿ɡ�
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
