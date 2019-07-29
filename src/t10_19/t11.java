package t10_19;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * PS:折半性质的算法的时间复杂度为 O(logN)
 */
public class t11 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Solution11 s = new Solution11();
        System.out.println(s.minNumberInRotateArray(arr));
    }
}

class Solution11 {
    //核心思想: 在旋转数组里二分查找! 注意mid之后区分要+1;
    public int minNumberInRotateArray(int[] array) {
        if (array.length < 1) return 0;
        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
//            if (array[l] == array[m] && array[l] == array[h])  //例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
//                return minNumber(array);
            if (array[m] <= array[h]) { // m~h 是非递减数组,  l~m 是旋转数组
                h = m;
            } else { // m~h 是旋转数组
                l = m + 1;  //注意边界要+1;
            }
        }
        return array[l];
    }

    //考虑元素重复的话在二分基础上加线性查找
//    private int minNumber(int[] arr) {
//        int l = 0, h = arr.length - 1;
//        for (int i = 0; i < arr.length; i++) {
//
//        }
//    }

}