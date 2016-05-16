package medium;

import java.util.*;

/*
 * 2016.5.16
 * ���num������nλ������0��2^n-1����ϡ�
 * ����ÿһ����϶�Ӧ���ǵ�ǰ�����У��ö����Ʊ�ʾ������1��Ӧ��λ����������ɵ����
 * ��ˣ�gen�Ǹ���һ�����֣�����ö����Ʊ��ҵ�����1��λ��������Ӧ��������ӵ�������ɡ�
 */
public class Q78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
			res.add(gen(nums, i));
		}
		return res;
	}

	public ArrayList<Integer> gen(int[] nums, int num) {
		String n = Integer.toBinaryString(num);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = n.length() - 1; i >= 0; i--) {
			if (n.charAt(i) == '1')
				res.add(nums[n.length() - 1 - i]);
		}
		return res;
	}
}
