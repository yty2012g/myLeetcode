package hard;
/*
 * 2016.5.1
 * 最简单的方法，仿照merge sort的做法，将两个数组merge，找到第（m+n）/2个数，得到中位数，时间复杂度为O(n/2);
 * 高级的方法，使用二分搜索的思想。将求中位数，等价变换至求第（m+n）/2小的数。
 * 此时问题变成求解第k小的数。
 * 首先，将k分成均分成两份，从a，b两个数组中计算，如果较小的数组装不下k/2个数，则设置为全部的数字，较大的数组分担剩下的数字。
 * 假设，a数组分担了pa，则b数组分担了k-pa。
 * 如果a[as+pa-1]<b[bs+pb-1],说明，a中的pa个数在合并的大数组中都是小于第k小的数的，则全部放弃。
 * 如果相等，则说明a[as+pa-1]就是所求的第k小的数。
 * 如果反之，则说明b中的pb个数全部放弃。
 * 停止的条件，可能1，小数组已经全部放弃了，则第k小的数为b[bs+k-1]
 *            可能2，k变成了1，则选取a，b中第一个较小的元素。
 *            
 * 最终时间复杂度为O(log(k)),也就是O(log((m+n)/2))
 * 求中位数，分成两种情况，大数组为奇数个，则为第（m+n）/2+1个数字，否则为第（m+n）/2个数字和第（m+n）/2+1个数字的平均数。
 */
public class Q4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0)
			return 0;
		if (nums1.length == 0)
			return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2
					: nums2[nums2.length / 2];
		if (nums2.length == 0)
			return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2
					: nums1[nums1.length / 2];
		boolean flag = true;
		if ((nums1.length + nums2.length) % 2 == 0)
			flag = true;
		else
			flag = false;
		int num = 0;
		int f1 = 0;
		int f2 = 0;
		int res1 = 0;
		int res2 = 0;
		for (int i = 0; i < nums1.length + nums2.length; i++) {
			if (f1 < nums1.length && f2 < nums2.length) {
				if (flag == false && num == (nums1.length + nums2.length) / 2)
					return nums1[f1] < nums2[f2] ? nums1[f1] : nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2 - 1)
					res1 = nums1[f1] < nums2[f2] ? nums1[f1] : nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2) {
					res2 = nums1[f1] < nums2[f2] ? nums1[f1] : nums2[f2];
					break;
				}
				if (nums1[f1] < nums2[f2])
					f1++;
				else
					f2++;
				num++;

			} else if (f1 < nums1.length) {
				if (flag == false && num == (nums1.length + nums2.length) / 2)
					return nums1[f1];
				if (flag == true && num == (nums1.length + nums2.length) / 2 - 1)
					res1 = nums1[f1];
				if (flag == true && num == (nums1.length + nums2.length) / 2) {
					res2 = nums1[f1];
					break;
				}
				f1++;
				num++;
			} else {
				if (flag == false && num == (nums1.length + nums2.length) / 2)
					return nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2 - 1)
					res1 = nums2[f2];
				if (flag == true && num == (nums1.length + nums2.length) / 2) {
					res2 = nums2[f2];
					break;
				}
				f2++;
				num++;
			}
		}
		return ((double) res1 + (double) res2) / 2;
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			return (findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2)
					+ findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1)) / 2;
		} else
			return findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1);
	}

	public double findK(int[] a, int as, int ae, int[] b, int bs, int be, int k) {
		int m = ae - as + 1;
		int n = be - bs + 1;
		if (m > n)
			return findK(b, bs, be, a, as, ae, k);
		if (m == 0)
			return b[bs + k - 1];
		if (k == 1)
			return Math.min(a[as], b[bs]);
		int pa = Math.min(k / 2, m);
		int pb = k - pa;
		if (a[as + pa - 1] < b[bs + pb - 1]) {
			return findK(a, as + pa, ae, b, bs, be, k - pa);
		} else if (a[as + pa - 1] > b[bs + pb - 1]) {
			return findK(a, as, ae, b, bs + pb, be, k - pb);
		} else {
			return a[as + pa - 1];
		}
	}
}
