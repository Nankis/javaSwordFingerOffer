package t60_68;


/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号。
 */
public class t65 {
    public static void main(String[] args) {

        System.out.println(Solution65.Add(2, 3)); //10   11
    }
}


class Solution65 {
    //^异或: 相同为0,不同为1   2<<1   ===> 左移1位
    public static int Add(int num1, int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }
}