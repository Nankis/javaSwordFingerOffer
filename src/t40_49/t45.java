package t40_49;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class t45 {
}

class Solution45 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length < 1) return "";
        String[] arrayStr = new String[numbers.length];

        for (int i = 0; i < arrayStr.length; i++) {
            arrayStr[i] = String.valueOf(numbers[i]);
        }
        //比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
        Arrays.sort(arrayStr, (s1, s2) -> ((s1 + s2).compareTo(s2 + s1)));
        StringBuilder sb = new StringBuilder();
        for (String str : arrayStr)
            sb.append(str);
        return sb.toString();

    }
}



