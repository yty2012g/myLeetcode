package easy;
/*
 * 2016.5.7
 * ˼·��Q26һ��������ð�ݵ��뷨��
 * ����һ��˼����ʽ����Ϊ��Q26��ͬ���ǣ��������������ġ���˿���ͨ���������ĩ���ҵ���һ��������val��Ԫ�أ�Ȼ��͵�ǰ����val��Ԫ�ؽ�����
 */
public class Q27 {
	public int removeElement(int[] nums, int val) {
		int du = 0;
		for (int i = 0; i < nums.length - du; i++) {
			if (nums[i] == val) {
				for (int j = i; j < nums.length - du - 1; j++) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
				du++;
				i--;
			}
		}
		return nums.length - du;
	}
}
