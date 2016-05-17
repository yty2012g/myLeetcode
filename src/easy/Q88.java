package easy;

/*
 * 2016.5.17
 * 合并两个数组，放到第一个数组中，那么就从结尾开始，也就是位置为m+n-1的元素开始。
 * 使用index1和index2分别标记两个数组当前处理的下标。
 * 如果一个数组已经拷完了，则直接拷另一个数组即可。
 */
public class Q88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0)
			return;
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		if (nums2[0] >= nums1[m - 1]) {
			for (int i = m; i < m + n; i++) {
				nums1[i] = nums2[i - m];
			}
			return;
		}
		if (nums1[0] >= nums2[n - 1]) {
			for (int i = n + m - 1; i >= n; i--) {
				nums1[i] = nums1[i - n];
			}
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		int index1 = m - 1;
		int index2 = n - 1;
		for (int i = m + n - 1; i >= 0; i--) {
			if (index1 >= 0 && index2 >= 0) {
				if (nums2[index2] > nums1[index1]) {
					nums1[i] = nums2[index2];
					index2--;
				} else {
					nums1[i] = nums1[index1];
					index1--;
				}
			} else if (index2 >= 0) {
				for (int j = index2; j >= 0; j--) {
					nums1[index2] = nums2[index2];
				}
				break;
			} else {
				for (int j = index1; j >= 0; j--) {
					nums1[index1] = nums1[index1];
				}
				break;
			}
		}
	}
}
