package medium;

/*
 * 2016.5.7
 * �������뷨�Ƚϼ�
 * ��һ�������ڲ���ʹ�ó˳���ȡģ������ͨ�����Ƶķ�ʽ���ҵ���һ�����ڵ��ڱ������ģ�������2���ݴη�����
 * �е��ƿڣ������֮�����ҵ�һ��2���ݴη���������Ϊx����������x���ڵ��ڱ�������ͬʱx�������2����ǰ��Ĳ���ʽ�ͱ��С�ڵ��ڡ�
 * �ڶ�����ֻҪʣ������ִ��ڵ��ڳ�����ʼѭ����ֻҪ��ǰ��ʣ�����ִ���x���ĳ�������ʣ�����ּ�ȥx���ĳ��������С�ڣ���x=x/2
 * ÿ�ν������x���ɡ�
 * 
 * ע�����1.int���͵�ȡֵ��Χ��0x80000000~0x7fffffff������ʹ��Math.abs()����ȡ����ֵʱ��Math.abs(0x80000000)�Ǹ��ġ�
 * ���ʹ�þ���ֵ����ʱ����Ҫ�Ƚ�Դ����ת����long���͡�
 * 2.�����ļ�֦������Ϊ0���������ڱ������������ľ���ֵ���ڱ������ľ���ֵ��
 * 3.Ψһ����������0x80000000����-1�����ڸ�����������һ����������������˽���ڼ���ʱӦʹ��long���͡�
 */
public class Q29 {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return 0x7FFFFFFF;
		if (dividend == divisor)
			return 1;
		if (Math.abs((long) dividend) < Math.abs((long) divisor))
			return 0;
		int sign = 1;
		if (dividend < 0)
			sign = -1 * sign;
		if (divisor < 0)
			sign = -1 * sign;
		long bcs = Math.abs((long) dividend);
		long cs = Math.abs((long) divisor);
		long c = 1;
		while (cs < bcs) {
			cs = cs << 1;
			c = c << 1;
		}
		long res = 0;
		while (bcs >= Math.abs(divisor)) {
			while (bcs >= cs) {
				bcs -= cs;
				res += c;
			}
			cs = cs >> 1;
			c = c >> 1;
		}
		return res * sign > 0x7fffffff ? 0x7fffffff : (int) res * sign;
	}
}
