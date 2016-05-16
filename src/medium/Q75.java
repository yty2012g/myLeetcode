package medium;

/*
 * 2016.5.16
 * ���úͿ���partitionһ���Ĳ��ԡ�
 * ������ɫ�ķֲ��Ǻ���������ֻҪ����ɫ����ɫ���ֺã�ʣ�µľ��ǰ�ɫ
 * ʹ��ri��¼��ɫ����±��ұ߽硣
 * ʹ��bi��¼��ɫ����±���߽硣
 * ���ĳһλ�Ǻ�ɫ������ɫ����ô�ͽ����Ԫ���ƶ�����Ӧ���±�߽磬ͬʱ�߽���չ��������Ԫ���Ѿ��ڱ߽��Աߣ��Ͳ����ƶ���ֱ����չ���С�
 */
public class Q75 {
	public void sortColors(int[] nums) {
		int ri = -1;
		int bi = nums.length;
		for (int i = 0; i < bi; i++) {
			while (nums[i] == 0 || nums[i] == 2) {
				if (nums[i] == 0) {
					if (i != ri + 1) {
						int temp = nums[ri + 1];
						nums[ri + 1] = nums[i];
						nums[i] = temp;
						ri++;
					} else {
						ri++;
						break;
					}
				}
				if (nums[i] == 2) {
					if (i != bi - 1) {
						int temp = nums[bi - 1];
						nums[bi - 1] = nums[i];
						nums[i] = temp;
						bi--;
					} else {
						bi--;
						break;
					}
				}
			}
		}
	}
}
