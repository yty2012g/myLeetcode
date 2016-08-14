package medium;

/*
 * 2016.8.13
 * ���ַ�������һ���ǻ���̰���㷨��ʱ�临�Ӷ�ΪO(N)��
 * һ�����������У��������ɸ����ڵĳ���Ϊ2�������鹹�ɵġ�
 * ���ʹ��flag��Ϊ��һ���������������ǽ���ı�ǡ�ÿ���ж�һ�����ڵ������У�����ǰ��ı�Ǻ͵�ǰ�Ĵ�С���ȷ���Ƿ��������е�һ���֡�
 * *********************************Ϊʲôһ�������ڵĳ���Ϊ2�������鹹�ɵ��أ�******************************
 * ���蹹�����������е�Ԫ�ض��ǲ����ڵģ�����a[i]��a[j]������j����i+1����������֮ǰ�ǵ����ġ�
 * ��ô����i��j�м��Ԫ��,����Ϊa[k]�����a[k]����a[i]����ô�����Խ�a[i]��a[k]�滻��һ��������У�����������ֲ��䡣
 * ���a[k]����a[i]���������a[k]������һ��������У�ͬʱ��һ�������ǵݼ����У�������ֲ��䡣
 * ���a[k]С��a[i],����a[j],��ô��һ��ݼ����оͻ��滻Ϊa[i]��a[k]��
 * ���a[k]С��a[j],��ô����һ��ĵ������оͻ��滻Ϊa[k]��a[j]��
 * ���ϣ��������һ���������ɸ����ڵ������鹹�ɵġ�
 * 
 * 
 * ----------------------�ڶ�������------------------------
 * ʹ��dp�ķ��������ڲ�֪�������еĵ�һ����ֵ�Ǹ�����������
 * ���ʹ������dp�������ֱ��¼�����͸����������
 * dp[i]��ʾ[0..i]�����������е���󳤶ȡ����Ը��ݳ������ж�֮ǰ�������ǽ���
 * �����һ����ֵ��������
 * ��ô�������һ��Ԫ��i���ԣ�dp[i]=max{max[dp[j]+1&&dp[j]������ && nums[i]>nums[j]],max[dp[j]+1&&dp[j]��ż�� && nums[i]<nums[j]]}
 * ���ԣ���ҪO(N^2)��ʱ�临�Ӷȡ�
 * 
 */
public class Q376 {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		Boolean flag = null;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1] && (flag == null || !flag)) {
				flag = true;
				count++;
			} else if (nums[i] < nums[i - 1] && (flag == null || flag)) {
				flag = false;
				count++;
			}
		}
		return count;
	}

	public int wiggleMaxLength2(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int[] dp = new int[nums.length];
		int[] dp2 = new int[nums.length];
		dp[0] = 1;
		dp2[0] = 1;
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			dp2[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j] && (dp[j] & 1) == 1) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} else if (nums[i] < nums[j] && (dp[j] & 1) == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				if (nums[i] < nums[j] && (dp2[j] & 1) == 1) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				} else if (nums[i] > nums[j] && (dp2[j] & 1) == 0) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
			max = Math.max(max, dp2[i]);
		}
		return max;
	}
}
