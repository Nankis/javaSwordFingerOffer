package top100;

public class t4 {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
//        System.out.println(findMedianSortedArrays2(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
        System.out.println(medianSortedArrays);
    }

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1 3 5    2 4 6
        int m = nums1.length;
        int n = nums2.length;
        //中位数
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;

    }

    //在两个有序数组中找到第k个元素,例如找到第一个元素,k=1,即nums[0]
    //i:nums1的起始位置,j:nums2的起始位置(i,j都是从0开始)
    private static double findKth(int[] nums1, int i, int[] nums2, int j, int k) {

        //若nums1为空,或是说其中数字全部被淘汰了
        //则在nums2中找第k个元素,此时nums2起始位置是j,所以是j+k+1
        if (i >= nums1.length) return nums2[j + k - 1];
        //nums2 同理
        if (j >= nums2.length) return nums1[i + k - 1];

        //递归出口 当K=1时候，相当于求最小值，我们只要比较nums1和nums2的起始位置i和j上的数字就可以了。
        if (k == 1) return Math.min(nums1[i], nums2[j]);

        //这两个数组的第k/2小的数字,若不足k/2个数字则赋值整型最大值,以便于淘汰另一个数组的前k/2个数字
        int minVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int minVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        //二分法核心部分
        if (minVal1 < minVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

}
