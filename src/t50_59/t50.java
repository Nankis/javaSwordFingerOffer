package t50_59;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class t50 {
}

class Solution50 {
    public int FirstNotRepeatingChar(String str) {
        // 65('A') ~ 122 'z'  -->只需要开 122 - 65 = 58个空间就行了
        if (str.length() < 1) return -1;
        int[] count = new int[58];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'A'] == 1) return i;
        }
        return -1;
    }
}