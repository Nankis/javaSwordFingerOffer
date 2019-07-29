package t10_19;

import java.util.Arrays;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * <p>
 * 具体分析:
 * * https://www.nowcoder.com/profile/5303495/codeBookDetail?submissionId=18721762
 * <p>
 * 常规做法: 递归...比较low
 * *      {       1,      n=0
 * * fn = |       1,      n=1
 * *      { 2*f(n-1) n>=2
 * <p>
 * 高端做法:
 * 继续优化 f(n) = 2*f(n-1)
 * f(n)=2*f(n-1); 假设n=3， 那么f3=2*2*f(1); 假设n=4,那么f(n)=2*2*2*f(1); 所以结果其实就是：2^(n-1)
 * 1<<--number  1左移number-1位 也就是2的（number-1）次方
 */
public class t10_4 {
    public static void main(String[] args) {

    }
}

class Solution10_4 {
    public int JumpFloorII(int target) {
        if (target <= 1) return 1;

        return 2 * JumpFloorII(target - 1);
    }
}

class Solution10_4s {
    public int JumpFloorII(int target) {
        return 1 << --target;
    }
}