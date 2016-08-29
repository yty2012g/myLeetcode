package medium;

/*
 * 2016.8.29
 * 这里是利用堆的特点
 * 以下标为1作为堆顶，然后由于使用数组来表示堆，所以第i个节点的左右节点的下标分别是2*i和2*i+1。
 * 因此第i个节点的两个子节点中1的个数是第i个节点的1的个数或者加1.所以应该是O(n)的时间复杂度。
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
