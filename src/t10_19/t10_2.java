package t10_19;

/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * <p>
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#101-%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97
 * *     {       1,      n=1
 * *fn = |       2,      n=2
 * *     { f(n-1)+f(n-2) n>2
 */
public class t10_2 {
    public static void main(String[] args) {
        Solution10_2 solution10_2 = new Solution10_2();
        System.out.println(solution10_2.RectCover(4));
    }
}

class Solution10_2 { //复习1,
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int fib = 0;
        int pre1 = 2;
        int pre2 = 1;  //大小递减
        for (int i = 3; i <= target; i++) {  //i从比pre2大的下一个开始
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}


class S10_2 {
    public int RectCover(int target) {
        if (target <= 2) return target;

        int fib = 0, pre1 = 2, pre2 = 1;

        for (int i = 3; i < target; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}