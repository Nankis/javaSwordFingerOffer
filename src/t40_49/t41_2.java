package t40_49;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 * <p>
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class t41_2 {
}

class Solution41_2 {
    //Insert one char from stringstream
    Map<Character, Integer> map = new LinkedHashMap<>(); //LinkedHshMap有序

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else
            map.put(ch, 1);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Character key : map.keySet()) {
            if (map.get(key) < 2)
                return key;
        }
        return '#';
    }
}