package t40_49;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入一个字符串（只包含 a~z 的字符），
 * 求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，
 * 最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class t48S {
    public static void main(String[] args) {
        System.out.println(s48.longestSubStringWithoutDuplication("arabcacfr"));
    }
}

class test48 {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}

//滑动窗口通用思想
class s48 {
    public static int longestSubStringWithoutDuplication(String str) {
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        while (right < str.length()) {
            char c1 = str.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;
            while (window.get(c1) > 1) {//左边开始缩减
                char c2 = str.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

class s48_ {
    public int longestSubStringWithoutDuplication(String str) {
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        while (right < str.length()) {
            char c1 = str.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            ++right;
            while (window.get(c1) > 1) {//出现重复,左边开始缩减
                char c2 = str.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}