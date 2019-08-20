package DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 参考: https://mp.weixin.qq.com/s/EWLi6sP3l4xsuc6GDpQAjw
 * 给定一个无序数组,找到其中最长上升子序列的长度
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长上升子序列是[2,3,7,101]
 * 说明:
 * - 可能会有多种最长上升子序列组合,只需要输出对应长度即可
 * - 复杂度至少O(n^2), 你可以优化到O(NLogN)
 */
public class LIS {
    public static void main(String[] args) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3},
        };
        System.out.println(LIS1.lengthOfLIS(arr));
        System.out.println(LIS2.maxEnvelopes(envelopes));

    }
}


class LIS1 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        int[] dp = new int[nums.length]; //存储以 nums[i] 结尾的数字最长子序列长度
        Arrays.fill(dp, 1); //长度至少为1

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

//参考https://mp.weixin.qq.com/s/wK3zCwMtT04DdvTo-FzQ1Q
class LIS2 {
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        //按宽度升序排列,如果宽度一样,则按高度排列
        Arrays.sort(envelopes,
                (int[] a, int[] b) -> a[0] == b[0] ? b[0] - a[0] : a[0] - b[0]);

        //对高度数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return LIS1.lengthOfLIS(height);
    }
}


