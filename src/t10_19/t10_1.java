package t10_19;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * <p>
 * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，
 * 但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 * <p>
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#101-%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97
 * <p>
 * *      {       0,      n=0
 * * fn = |       1,      n=1
 * *      { f(n-0)+f(n-1) n>1
 */
public class t10_1 { //复习1,
    public static void main(String[] args) {
        Solution10_1 s = new Solution10_1();
        System.out.println(s.Fibonacci(5));
    }
}

class Solution10_1 {
    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int fib = 0;
        int pre1 = 1;
        int pre2 = 0;

        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}


class S10_1 {
    public int Fibonacci(int n) {
        if (n < 0) return -1;
        int fib = 0, pre1 = 1, pre2 = 0;

        for (int i = 2; i < n; i++) {
            fib = pre1 + pre2;
            pre2 = pre1; //向后进位
            pre1 = fib;
        }

        return fib;
    }
}