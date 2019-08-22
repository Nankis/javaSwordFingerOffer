package doublePointer;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * 双指针滑动窗口解决子串问题--通用方法
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 核心思路:
 * * string s, t;
 * * int left = 0, right = 0;// 在 s 中寻找 t 的「最小覆盖子串」
 * * string res = s;
 * *
 * * while(right < s.size()) {
 * *     window.add(s[right]);
 * *    right++;
 * *     // 如果符合要求，移动 left 缩小窗口
 * *    while (window 符合要求) {
 * *         // 如果这个窗口的子串更短，则更新 res
 * *        res = minLen(res, window);
 * *        window.remove(s[left]);
 * *        left++;
 * *     }
 * * }
 * * return res;
 */

public class slidingWindow {
    public static void main(String[] args) {
        String S = "EBBANCF";
        String T = "ABC";
//        System.out.println(SW1.minWindow(S, T));

        System.out.println(SW3.lengthOfLongestSubstring("abcabcbb"));
    }
}

/**
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 如S="EBBANCF"  T="ABC"   输出"BANC"
 */

class SW1 {
    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, start = 0;

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        //向map中添加key,如果没有就创建,且第二个参数默认值是0,有就直接取出原先的值,并+1
        //初始化needs
        for (char c : t.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);

        int match = 0;//用于判断window中是否包含全部needs的字符

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {//判断当前位置s中的字符是否包含子串中的字符
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                //这里不能用if(needs.get(c1)==window.get(c1)) 否则当字符串S和T特别长的时候就无法通过
                //因为Integer是对象,超过了常量池的数值,会比较地址
                if (needs.get(c1).equals(window.get(c1)))  //window.get(c1).equals(needs.get(c1)) 会报空指针异常
                    match++;
            }
            right++; //该句不能放到后面

            while (match == needs.size()) { //window现在已经包含了needs的全部字符
                if (right - left < minLen) { //如果当前满足条件的子串比之前的还小,则更新最小子串的位置和长度
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);//第二个参数是start+mL
    }
}

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */
class SW2 {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);
        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (needs.get(c1).equals(window.get(c1)))
                    match++;
            }
            right++;

            while (match == needs.size()) {
                //如果window的大小刚好满足,就把起始索引left加入结果
                if (right - left == p.length())
                    res.add(left);

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }

        return res;
    }
}

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

class SW3 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>(); //传入单参则只需要一个window,双参则多一个needs
        int res = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;
            // 如果 window 中出现重复字符
            // 开始移动 left 缩小窗口
            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

/**
 * 通过上面三道题，我们可以总结出滑动窗口算法的抽象思想：
 * * int left = 0, right = 0;
 * *
 * * while (right < s.size()) {
 * *     window.add(s[right]);
 * *     right++;
 * *
 * *     while (valid) {
 * *         window.remove(s[left]);
 * *         left++;
 * *     }
 * * }
 */
