package medium;

import java.util.Arrays;

/*
 * 2016.9.1
 * �����Ŀֻ�����Ƿ������Ԫ�顣��Ҫ��o1�Ŀռ临�Ӷȣ�Ҳ���������ˣ���Ϊ��ǳ��ȵ�����ֻҪ�ﵽ3�����ǳ�������Ԫ�顣
 * ���Գ���������ĳ����ǹ̶��ģ�����4.���Ҳ����O1�Ŀռ临�Ӷ��ˡ�
 * �������õ�������������еĽ������������ʹ��һ��len���飬len[i]��ʾ������Ϊi�ĵ��������е����һλ��С�����Ƕ��١�
 * Ȼ��ÿ������arrays.binarySearch�����ҵ�һ�����õ�λ�á�
 * 3ms������������
 */
public class Q334 {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int[] len = new int[nums.length];
		len[0] = nums[0];
		int l = 1;
		for (int i = 1; i < nums.length; i++) {
			int pos = Arrays.binarySearch(nums, 0, l, nums[i]);
			if (pos < 0) {
				pos = -1 * (pos + 1);
				if (pos == l)
					l++;
				nums[pos] = nums[i];
			}
			if (l > 2)
				return true;
		}
		return false;
	}
}
