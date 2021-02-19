package top100;

import java.util.HashMap;
import java.util.Map;

public class t3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return -1;
        Map<Character, Integer> window = new HashMap<>();
        int right = 0;
        int left = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            //有重复的字母
            while (window.get(c) > 1) {
                //开始收缩左边
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                ++left;
            }
            ++right;
            res = Math.max(res, right - left);
        }

        return res;

    }

    public static int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            if (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}
