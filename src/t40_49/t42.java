package t40_49;

public class t42 {
}

//{6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
class Solution42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length < 1) return 0;
        int res = array[0]; //记录当前所有子数组和的最大值
        int arrayMax = array[0]; //记录包含arr[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            arrayMax = Math.max(arrayMax + array[i], array[i]);
            res = Math.max(res, arrayMax);
        }
        return res;
    }


    //方法2,不用考虑下标的
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array.length < 1) return 0;
        int res = array[0]; //记录当前所有子数组和的最大值
        int arrayMax = Integer.MIN_VALUE; //记录包含arr[i]的连续数组最大值
        for (int val : array) {
            arrayMax = val <= 0 ? val : arrayMax + val;
            res = Math.max(res, arrayMax);
        }

        return res;
    }


}