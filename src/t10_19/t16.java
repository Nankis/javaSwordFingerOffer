package t10_19;

/**
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 */
public class t16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
//        System.out.println(solution16.Power(2, 0));
        System.out.println(solution16.Powers(2, 3));
    }
}

class Solution16 {
    public double Power(double base, int exponent) { //base^exponent  普通解法:  复杂度n
//        if (exponent == 0) return 1;  多余
        double result = 1;

        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }

        return exponent < 0 ? 1 / result : result;

    }

    public double Powers(double base, int exponent) { //递归解法  lgn
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        boolean isNegative = false; //判断是否负数

        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        double pow = Powers(base * base, exponent / 2);

        if (exponent % 2 != 0)
            pow *= base; //由于整除精度丢失的原因,奇数会进入多乘一次

        return isNegative ? 1 / pow : pow;


    }
}