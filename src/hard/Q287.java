package hard;

/*
 * 2016.7.26
 * �������̫�����ˡ�
 * ���ȣ�nums������N+1�����֣�����1��N�����֡�����nums[0]��=0
 * ��Σ����һ�����ƹ�ʽ��n(k+1)=f[n(k)],Ҳ����ͨ����k��������Ϊ��k+1�����ֵ��±��ҵ���k+1�����֡�
 * �����������ظ����֣���Ȼ�л���
 * ��Ϊͨ�����ƹ�ʽ�����γ������������û���ظ����֣���ôһ��������±�Խ��������
 * ����ҵ������ɡ�
 */
public class Q287 {
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		// �ҵ�����ָ�������ĵط�
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		int find = 0;
		// ��һ����ָ���ͷ��ʼ��ֱ������ָ������
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
}
