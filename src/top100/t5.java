package top100;

import java.util.HashMap;
import java.util.Map;

public class t5 {
    public static void main(String[] args) {
        String s = "babad";
        String s2 = "bacbcad";
        String s3 = "cbbd";
        String s4 = "ccc";
        String s5 = "ac";
        System.out.println(longestPalindrome2(s4));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int len = chars.length;

        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        //初始化对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
                    //这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，
                    // 其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
                    if ((j - 1) - (i + 1) + 1 < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //给你一个字符串 s，找到 s 中最长的回文子串。
    //暴力
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) return s;
        int len = s.length();
        //maxLen 表示 对比的两个字母最大距离
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                //j-i+1 表示 两个字母间距
                if (j - i + 1 > maxLen & VerifyP(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static boolean VerifyP(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            --j;
            ++i;
        }
        return true;
    }
}
