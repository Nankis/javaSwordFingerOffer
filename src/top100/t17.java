package top100;

import java.util.*;

public class t17 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    //使用HashMap存放字符与字符串对应关系
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) return res;
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int index) {
        //终止条件："abc"遍历完成。
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        //根据索引获取数字
        char digit = digits.charAt(index);
        //根据数字获取字符串数组
        char[] chars = phoneMap.get(digit).toCharArray();
        //依次遍历
        for (int i = 0; i < chars.length; i++) {
            //无需去重?
            path.append(chars[i]);
            //回溯
            backtracking(digits, index + 1);
            //撤销选择
            path.deleteCharAt(path.length() - 1);
        }
    }


}
