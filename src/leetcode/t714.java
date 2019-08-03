package leetcode;

/**
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 */

public class t714 {
    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
        int[] arr = {1, 3, 2, 8, 4, 9};
        System.out.println(solution714.maxProfit(arr, 2));
    }
}

class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0 || len == 1) return 0;//边界条件
        int sum = 0, cur = 0;
        int max = prices[0], min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);//记录当前最小值
            max = Math.max(max, prices[i]);//记录当前的最大值
            cur = Math.max(cur, prices[i] - min - fee);//记录当前可能的最大收益
            if (max - prices[i] > fee) {//如果掉价超过了手续费还不如花手续费买卖股票
                sum += cur;//赶紧抛出手中股票，能转多少是多少，然后又重新开始
                min = prices[i];
                max = prices[i];
                cur = 0;
            }
        }
        sum += cur;
        return sum;
    }
}