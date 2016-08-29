package medium;

/*
 * 2016.8.29
 * ���������öѵ��ص�
 * ���±�Ϊ1��Ϊ�Ѷ���Ȼ������ʹ����������ʾ�ѣ����Ե�i���ڵ�����ҽڵ���±�ֱ���2*i��2*i+1��
 * ��˵�i���ڵ�������ӽڵ���1�ĸ����ǵ�i���ڵ��1�ĸ������߼�1.����Ӧ����O(n)��ʱ�临�Ӷȡ�
 */
public class Q338 {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		if (num < 0)
			return null;
		if (num == 0)
			res[0] = 0;
		else if (num == 1) {
			res[0] = 0;
			res[1] = 1;
		} else {
			res[0] = 0;
			res[1] = 1;
			for (int i = 1; i <= (num >> 1); i++) {
				if ((i << 1) <= num)
					res[i << 1] = res[i];
				if ((i << 1) + 1 <= num)
					res[(i << 1) + 1] = res[i] + 1;
			}
		}
		return res;
	}
}
