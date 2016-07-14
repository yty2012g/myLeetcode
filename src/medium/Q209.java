package medium;

/*
 * 2016.7.14
 * ��һ��������ӵ�0�����ֿ�ʼ����Ҫ���ٸ������ܹ�ʵ��sum���ڵ���s�������鳤�ȼ�¼��len����ֵ��¼��cha�С�
 * �ڶ��������ڵ�i�����֣���ȥ��i-1�����ֵĲ�ֵΪcha[i - 1] - nums[i - 1]�������ֵ����0���򳤶ȱ�len[i-1]��1����ֵ��Ӧ����
 *         �����ֵС��0����ô�ʹӵ�i-1�����ֶ�Ӧ���������ĩβ����һ��Ԫ�ؿ�ʼ���ӣ�ֱ����ֵ���ڵ���0��
 *         ����ӵ����һ�����ֶ��޷�ʹ��ֵ����0����˵���ӵ�i������֮�����������֮�Ͷ���С��sum�ģ�����֮ǰ����С���ȼ��ɡ�
 *         ����ӵ�ĳһλ����ֵ����0�����¼len��cha�����ұȽ�len��min��ȡ��С�ĸ�ֵ��min
 */
public class Q209 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] len = new int[nums.length];
		int[] cha = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum >= s) {
				cha[0] = sum - s;
				len[0] = i + 1;
				break;
			}
		}
		if (len[0] == 0)
			return 0;
		int min = len[0];
		for (int i = 1; i < nums.length; i++) {
			int tempSum = cha[i - 1] - nums[i - 1];
			if (tempSum >= 0) {
				len[i] = len[i - 1] - 1;
				min = Math.min(len[i], min);
				cha[i] = tempSum;
			} else {
				if (i + len[i - 1] - 1 < nums.length) {
					for (int j = i + len[i - 1] - 1; j < nums.length; j++) {
						tempSum += nums[j];
						if (tempSum >= 0) {
							len[i] = j - i + 1;
							cha[i] = tempSum;
							break;
						}
					}
					if (tempSum >= 0)
						min = Math.min(len[i], min);
					else
						break;
				} else {
					break;
				}
			}
			if (len[i] == 1 || nums[i] == s)
				return 1;
		}
		return min;
	}
}
