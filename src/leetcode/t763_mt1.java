package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 * 19年美团第一题
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 */
public class t763_mt1 {
    public static void main(String[] args) {

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * 思路:用map记录每个字符出现的最后索引,每次更新会遇到不同的字符,由left和right组成一个区间,
     * 如果right指针在向右过程中遇到新的字符就代表该区间增大
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++)
            map.put(S.charAt(i), i);  //记录字符和其出现的最后索引

        int left = 0, right = 0;

        for (int i = 0; i < S.length(); i++) {
            right = Math.max(right, map.get(S.charAt(i))); //区间最右边
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
//        System.out.println(map);

        return res;
    }
}
