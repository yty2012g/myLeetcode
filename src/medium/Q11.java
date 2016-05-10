package medium;
/*
 * 2016.5.4
 * ���ַ������Ͽ�ķ����Ƿ���1.
 * ��һ�ַ�����ά��һ��startָ���endָ�룬����ͷ���м�ɨ�裬ÿ�εõ�һ���ʱ����һ��ߵļ������ҵ�����С�߿����ڲ�ĵ�һ���ȴ˱߳��ı�
 * �ڶ��ַ�����ʹ��һ��n*n�����飬�洢��������������������ݻ����ҵ����ֵ��
 * �����ַ�����ά��һ��startָ���endָ�룬����ͷ���м�ɨ�裬ÿ�εõ�һ���ʱ����һ����ǽ���С�ı������ƶ�һ�񣬵õ��ġ�
 * Ϊʲô��һ�ַ����Ͽ��أ���������������
 * 1.�ݻ�����Math.min(a,b)*(b���±�-a���±�)
 * 2.�����ҵ�������ݻ���ɵı�Ϊi��j
 * 3.��i����߲��ܴ���һ���߱�iҪ�󣬷����ݻ�һ��������ġ�ͬ��j���ұ߲����ܴ���һ���߱�jҪ��
 * 4.����3��ÿ��ɨ�裬���ӽ�С�ı߿�ʼ���ҵ���һ���ȴ˱ߴ�ıߣ���˷���1��ȽϷ���3���������ڣ��ټ����˺ܶ�ߡ�
 * 5.4��֤�����£�����startָ��Ϊ��С�ıߣ����start�Ҳ���һ����startС�ıߣ�����4Ӧ��������
 * ���ݹ�ʽ��Math.min(a,b)*(b���±�-a���±�)�������ʱΪx����Ϊx<a,����Math.min(a,b)>Math.min(x,b)��aΪa��b�н�С�ıߡ�
 * ��x��a���Ҳ࣬���(b���±�-a���±�)>(b���±�-x���±�),����start�Ҳ��startС�ı���ɵ��������ݻ��ڼ�С��
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
