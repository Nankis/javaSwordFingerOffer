package t20_29;


/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * []  ： 字符集合
 * ()  ： 分组    ---->强制性的,必须有
 * ?   ： 重复 0 ~ 1 次
 * +   ： 重复 1 ~ n 次
 * *   ： 重复 0 ~ n 次
 * .   ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 */
public class t20S { //复习1,
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        char[] a = {'-', '.', '1', '2', '3'};
        System.out.println(solution20.isNumeric(a));
    }
}

class Solution20 {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}

class Solution20_ {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
