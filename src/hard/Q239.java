package hard;

import java.util.*;

/*
 * 2016.7.22
 * ����������˫�˶��е����ݽṹ��
 * ��������һ��˫�˶��б��棬���������а���ֵ��С���е��±ꡣ
 * ���ڵ�x�����֣�������Ȼ�������ĩβ�����ִ���ô�Ͱ�ĩβ�������޳���ֱ������ĩβ������Сʱ��������С�
 * Ϊʲô�޳��أ���Ϊ���ȶ��е����ֳ��ֱ�x�磬����ȴ��xС����ʱ��ʹ�������ڣ���̭��Ҳֻ������Щ���ֲ�����x��������Щ���־�û�����ˡ�
 * �����ʱ���Թ����������ڣ���i>=k-1�����˫�˶��еĶ�ͷ��Ԫ��ΪʧЧ����res[i]���Ƕ�ͷ��Ԫ�أ����ʧЧ�ˣ����޳����ٴαȽϣ�ֱ����ͷԪ����Чλ�á�
 *            
 */
public class Q239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return nums;
		int[] res = new int[nums.length - k + 1];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < k - 1; i++) {
			while (list.size() > 0 && nums[i] >= nums[list.get(list.size() - 1)]) {
				list.remove(list.size() - 1);
			}
			list.add(i);
		}
		for (int i = k - 1; i < nums.length; i++) {
			while (list.size() > 0 && nums[i] >= nums[list.get(list.size() - 1)]) {
				list.remove(list.size() - 1);
			}
			list.add(i);
			while (i - list.get(0) + 1 > k) {
				list.removeFirst();
			}
			res[i - k + 1] = nums[list.get(0)];
		}
		return res;
	}
}
