package t10_19;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 思路:
 * 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。
 * 而 n-1 和 n-2 阶台阶的跳法可以看成子问题，该问题的递推公式为：
 * * *      {       1,      n=1
 * * * fn = |       2,      n=2
 * * *      { f(n-1)+f(n-2) n>2
 * <p>
 */
public class t10_3 {
}

class Solution10_3 {
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        int fib = 0;
        int pre1 = 2;
        int pre2 = 1;

        for (int i = 3; i <= target; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }

        return fib;
    }
}
