package medium;
/*
 * 2016.5.4
 * 三种方法，较快的方法是方法1.
 * 第一种方法，维护一个start指针和end指针，从两头向中间扫描，每次得到一组边时，下一组边的计算是找到，较小边靠近内侧的第一个比此边长的边
 * 第二种方法，使用一个n*n的数组，存储任意两条边组成容器的容积，找到最大值。
 * 第三种方法，维护一个start指针和end指针，从两头向中间扫描，每次得到一组边时，下一组边是将较小的边向内移动一格，得到的。
 * 为什么第一种方法较快呢？基于以下条件：
 * 1.容积等于Math.min(a,b)*(b的下标-a的下标)
 * 2.假设找到的最大容积组成的边为i，j
 * 3.在i的左边不能存在一条边比i要大，否则容积一定是增大的。同理，j的右边不可能存在一条边比j要大。
 * 4.根据3，每次扫描，均从较小的边开始，找到第一个比此边大的边，因此方法1相比较方法3的优势在于，少计算了很多边。
 * 5.4的证明如下，假设start指针为较小的边，如果start右侧有一个比start小的边，按照4应该跳过。
 * 根据公式，Math.min(a,b)*(b的下标-a的下标)，假设此时为x，因为x<a,所以Math.min(a,b)>Math.min(x,b)，a为a和b中较小的边。
 * 而x在a的右侧，因此(b的下标-a的下标)>(b的下标-x的下标),所以start右侧比start小的边组成的容器，容积在减小。
 */
public class Q11 {
	public int maxArea(int[] height) {
		int h = height.length;
		int start = 0;
		int end = h - 1;
		int max = 0;
		while (start < end) {
			max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
			if (height[start] < height[end]) {
				int middle = start;
				while (middle < end && height[middle] <= height[start])
					middle++;
				start = middle;
			} else {
				int middle = end;
				while (middle > start && height[middle] <= height[end])
					middle++;
				end = middle;
			}
		}
		return max;
	}

	public int maxArea2(int[] height) {
		int h = height.length;
		int max = 0;
		int temp = 0;
		for (int i = 0; i < h - 1; i++) {
			for (int j = i + 1; j < h; j++) {
				temp = Math.min(height[i], height[j]) * (j - i);
				max = temp > max ? temp : max;
			}
		}
		return max;
	}

	public int maxArea3(int[] height) {
		int h=height.length;
		int start=0;
		int end=h-1;
		int max=0;
		while(start!=end){
			int temp=Math.min(height[start], height[end])*(end-start);
			if(temp>max) max=temp;
			if(Math.min(height[start], height[end])==height[start]) start++;
			else end--;
		}
		return max;
	}
}
