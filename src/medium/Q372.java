package medium;

/*
 * 2016.8.16
 * ���ַ�����
 * ��һ�֣����ڶ��ֺ�����ķ�����ʵ��һ���߾��ȳ����ķ�����ÿ�ν������������ֳ���2��Ȼ�����ö�����ʵ�ֿ����ݡ�6xxms
 * �ڶ��֣����ڶ��ֺ�bigInteger�ķ����������ʹ��bigInteger��modPow������������һ����ֻ�����߾��ȳ����Ѿ���ʵ���ˡ�4xxms/1xxms
 * �����֣����񼶷����������ݴη���1337ȥģ�����ֻ����1337�������ôһ������֣�ÿ��һ��ѭ�����ڳ���һ����ͬ��������
 *        Ȼ�󣬼���ѭ�����ڣ��������������ʼ��ÿ�γ���a��ȡģ��һ���͵�һ����ͬ������Եó�ѭ�����ڡ�
 *        ��Ȼ�󣬶������ʾ�����ֶ�ѭ������ȡģ���õ��������ٴӸղŵ����������ҵ���Ӧ��λ�á����ɵõ����ս���� 2ms
 */
public class Q372 {
	public int superPow2(int a, int[] b) {
		if (a == 1)
			return 1;
		int l = b.length, m = a, i, v = 0;
		int[] p = new int[1337];
		int mod = a % 1337;
		p[0] = mod;
		for (i = 1; i < 1337; i++) {
			m = (int) (((long) m * a) % 1337);
			if (m != mod)
				p[i] = m;
			else
				break;
		}
		for (int j = 0; j < l; j++) {
			v = ((v * 10) + b[j]) % i;
		}
		return p[v - 1];
	}

	java.math.BigInteger two = new java.math.BigInteger("2");

	public int superPow(int a, int[] b) {
		String s = "";
		for (int i = 0; i < b.length; i++) {
			s += b[i];
		}
		java.math.BigInteger bi = new java.math.BigInteger(s);
		java.math.BigInteger ai = java.math.BigInteger.valueOf(a);
		return ai.modPow(bi, new java.math.BigInteger("1337")).intValue();

	}

	public int cal(int a, java.math.BigInteger bi) {
		if (bi.equals(java.math.BigInteger.ONE))
			return a % 1337;
		if (!bi.mod(two).equals(java.math.BigInteger.ONE)) {
			int temp = cal(a, bi.divide(two)) % 1337;
			return (temp * temp) % 1337;
		} else {
			int temp = cal(a, bi.subtract(java.math.BigInteger.ONE).divide(two)) % 1337;
			return ((temp * temp) % 1337 * a) % 1337;
		}
	}

}
