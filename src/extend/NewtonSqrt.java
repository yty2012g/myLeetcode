package extend;

/*
 * 2016.7.19
 * ţ�ٵ�������ƽ������
 * ��Ӧ���̣�f(x)=x^2-S,��ú����Ľ⣬��ΪS��ƽ������
 * �������߹�ʽ����x=x0�������߷���Ϊf(x)=f(x0)+f'(x0)*(x-x0)
 * ��������x��Ľ���Ϊx=x0-f(x0)/f'(x0)
 * ��ˣ����Եõ�x�ĵ��ƹ�ʽ��xn=xn-1-f(xn-1)/f'(xn-1)
 * Ȼ���f(x)�Ĺ�ʽ�������棬����Եõ�xn=(xn-1+S/xn-1)/2;
 * ����ţ�ٵ�������ƽ�������ġ��������ٶȺܿ졣
 */
public class NewtonSqrt {
	public double sqrt(int n) {
		double k = 1;
		while (Math.abs(k * k - n) > 1e-10) {
			k = 0.5 * (k + n / k);
		}
		return k;
	}
}
