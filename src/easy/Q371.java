package easy;

/*
 * 2016.8.17
 * 两个数字做加法。
 * 首先得到当前位的异或值。只有两个数字当前位都是1的时候，或者出现一个1但是有进位情况的时候，会出现进位的情况。此时nextflag为1
 * 然后，在将当前位的异或值和之前的进位值进行异或，再将结果左移后与临时结果或即可。
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
