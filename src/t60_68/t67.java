package t60_68;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class t67 {
    public static void main(String[] args) {
        System.out.println(Solution67.StrToInt("+122"));
    }
}

class Solution67 {
    public static int StrToInt(String str) {
        if (str == null || str.length() < 1) return 0;
        boolean isNegative = str.charAt(0) == '-';
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '-' || ch == '+'))
                continue;
            if (ch < '0' || ch > '9')
                return 0;
            res = res * 10 + (ch - '0'); //实际上这步存在溢出  需要判断溢出
        }

        return isNegative ? -res : res;
    }
}