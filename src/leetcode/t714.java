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
 * <p>
 * dp[-1][k][0] = 0
 * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
 * dp[-1][k][1] = -infinity
 * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
 * dp[i][0][0] = 0
 * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
 * dp[i][0][1] = -infinity
 * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
 * <p>
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class t714 {
    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
        int[] arr = {1, 3, 7, 5, 10, 3};
        System.out.println(solution714.maxProfit(arr, 3));
    }
}

/**
 * [1,3,7,5,10,3]
 * 3
 * [1,3,2,8,4,9]
 * 2
 */
class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //base case
        for (int i = 0; i < n; ++i) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            int temp =
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i] - fee);
            //dp[i - 1][0] 不能写在这里 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
        }
        return dp[n - 1][0];
    }

    //但是这样处理 base case 很麻烦，而且注意一下状态转移方程，新状态只和相邻的一个状态有关，其实不用整个 dp 数组，
    // 只需要一个变量储存相邻的那个状态就足够了，这样可以把空间复杂度降到 O(1):
    public int maxProfit2(int[] prices, int fee) {
        //k==无穷   ===> 可以认为 k 和k-1是一样的   我们发现数组中的k已经不会改变了，也就是说不需要记录 k 这个状态了
        int n = prices.length;
        //base case: dp[-1][0] = 0,  dp[-1][1] = -infinity
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);  //用这种方法 因为min_value是最小的, 如果在这里减去fee 会造成溢出
            // dp_i_1 = Math.max(dp_i_1, temp- prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);  //因为这里dp_i_0 初始值就是0
        }
        return dp_i_0;
    }
}

class s714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;  //数组模型 base case要减去fee
                continue;
            }
            //int temp = dp[i][0];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }

}