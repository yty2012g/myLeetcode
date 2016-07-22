package medium;

/*
 * 2016.7.22
 * ��������ط�����
 * ����������������������һ��O��n��ʱ�临�Ӷȡ��ڶ��������ó���
 * ʹ��������������飬dp1[i]��ʾ[0...i-1]������ĳ˻���dp2[i]��ʾ[i+1...n-1]������ĳ˻���
 * res[i]��ʾ���յĳ˻���������dp1[i]����dp2[i]��������ʵ�õ��˶�̬�滮��˼�롣
 */
public class Q238 {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		int[] res = new int[n];
		dp1[0] = 1;
		dp2[n - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp1[i] = dp1[i - 1] * nums[i - 1];
			dp2[n - 1 - i] = dp2[n - 1 - i + 1] * nums[n - 1 - i + 1];
		}
		for (int i = 0; i < nums.length; i++) {
			res[i] = dp1[i] * dp2[i];
		}
		return res;
	}
}
