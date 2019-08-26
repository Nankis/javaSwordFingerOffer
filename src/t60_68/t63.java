package t60_68;


/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class t63 {


    public static void main(String[] args) {
        Solution63 so = new Solution63();
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(so.maxProfit(arr));
    }
}

//[7,1,5,3,6,4]
class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int n = prices.length;
        //k==无穷   ===> 可以认为 k 和k-1是一样的   我们发现数组中的k已经不会改变了，也就是说不需要记录 k 这个状态了
        //base case: dp[-1][0] = 0,  dp[-1][1] = -infinity
        int[][] dp = new int[n][2];  //i k 股票

        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
