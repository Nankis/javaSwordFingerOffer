package DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://mp.weixin.qq.com/s/CypiIqbd007wYcV5Et_hRA
 * intvs=[[1,3],[3,6],[2,4]]，这些区间最多有两个区间互不相交，即[[1,3],[3,6]]，你的算法应该返回 2,注意边界相同并不算相交。
 */
public class Greedy {
    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {3, 6}, {2, 4}};
        int[][] nums2 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        System.out.println(greed1.intervalSchedule(ints));

        System.out.println(greedy2.maxUnOver(nums2));

    }
}

class greed1 {
    public static int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        //按end升序排列 (数组第二维升序)
        Arrays.sort(intvs, (int[] a, int[] b) -> a[1] - b[1]);
        int count = 1; //不相交区间  至少有一个区间不相交?
        //排序后 第一个区间就是x
        int x_end = intvs[0][1];
        for (int[] iv : intvs) {
            int start = iv[0];
            if (x_end <= start) {//边界相等也算不相交 [1,3] [3,4]
                count++;
                x_end = iv[1]; //取1而不是0 是因为要取end
            }

        }
        return count;

    }
}

//435https://leetcode-cn.com/problems/non-overlapping-intervals/
class greedy2 {
    //可以根据区间的end排序后,再用隔断方式求得-->最多有多少个区间不会重叠
    //那么总的去掉不会重叠的区间,就是应该去掉的区间数量
    public static int maxUnOver(int[][] nums) {
        int len = nums.length;
        //按照二维数组的第二个数升序 如[2,3][3,1] ---> [3,1],[2,3]
        Arrays.sort(nums, (int[] a, int[] b) -> a[1] - b[1]);
        int count = 1; //至少有1个区间不重叠
        int x_end = nums[0][1];  //第一个x_end
        for (int[] v : nums) {
            if (x_end <= v[0]) { //start  当前区间的end 小于不相交区间的start
                count++;
                x_end = v[1];
            }
        }
        return len - count;
    }
}

//合并区间  leetcode 56
class greedy3 {
//    public static ArrayList<ArrayList<Integer>> merge(int[][] intervals) {
//        if (intervals == null || intervals.length < 1) return new ArrayList<>();
//        //按照start排升序
//        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        res.add()
//    }
}
