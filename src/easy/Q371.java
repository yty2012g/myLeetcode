package easy;

/*
 * 2016.8.17
 * �����������ӷ���
 * ���ȵõ���ǰλ�����ֵ��ֻ���������ֵ�ǰλ����1��ʱ�򣬻��߳���һ��1�����н�λ�����ʱ�򣬻���ֽ�λ���������ʱnextflagΪ1
 * Ȼ���ڽ���ǰλ�����ֵ��֮ǰ�Ľ�λֵ��������ٽ�������ƺ�����ʱ����򼴿ɡ�
 */
public class Q371 {
	public int getSum(int a, int b) {
		int res = 0;
		int flag = 0;
		for (int i = 0; i < 32; i++) {
			int temp = ((a >> i) & 1) ^ ((b >> i) & 1);
			int nextflag = 0;
			if ((temp == 0 && ((a >> i) & 1) == 1) || (temp == 1 && flag == 1)) {
				nextflag = 1;
			}
			temp = temp ^ flag;
			flag = nextflag;
			res |= temp << i;
		}
		return res;
	}
}
