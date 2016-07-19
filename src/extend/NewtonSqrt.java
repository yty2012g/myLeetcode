package extend;

/*
 * 2016.7.19
 * 牛顿迭代法求平方根。
 * 对应方程，f(x)=x^2-S,求该函数的解，则为S的平方根。
 * 根据切线公式，在x=x0处的切线方程为f(x)=f(x0)+f'(x0)*(x-x0)
 * 该切线与x轴的交点为x=x0-f(x0)/f'(x0)
 * 因此，可以得到x的递推公式。xn=xn-1-f(xn-1)/f'(xn-1)
 * 然后把f(x)的公式带入上面，则可以得到xn=(xn-1+S/xn-1)/2;
 * 由于牛顿迭代法是平方收敛的。。所以速度很快。
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
