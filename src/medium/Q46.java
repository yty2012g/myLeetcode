package medium;

import java.util.*;

/*
 * 2016.5.10
 * �����ֵ�������ȫ�����㷨����Ŀ���ᵽû���ظ������֣����Ƿֳ��ĸ�����
 * ��һ���Ӻ���ǰ�ң��ҵ���i��Ԫ��ʹ�õ�i��Ԫ�ش��ڵ�i-1��Ԫ�أ���¼indexΪi-1��
 * �ڶ�����index+1��Ԫ�ؿ�ʼ�ң��ҵ����һ���ȵ�index��Ԫ�ش��Ԫ�أ��±��ΪindexB
 * ���������indexA��indexBͬʱΪ0��˵����ǰ����Ϊ�ݼ����У����ȫ�����������һ�����С�
 * ���ģ����±�ΪindexA��indexB��Ԫ�ؽ��������±��indexA+1����β��Ԫ�ط��������һ�����С�
 * 
 * �����ڽ�����ת����arraylist�Ĺ����оͼ�����ȫ���е���������Ϊnum
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
