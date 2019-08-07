package t30_39;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class t39 {
}

class Solution39 {
    //解法1:参考https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        int majority = array[0];
        for (int i = 1, cnt = 1; i < array.length; i++) {
            cnt = majority == array[i] ? cnt + 1 : cnt - 1;
            if (cnt == 0) { //换目标
                majority = array[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : array) {
            if (majority == val)
                cnt++;
        }
        return cnt > (array.length / 2) ? majority : 0;
    }


    //解法2 用map
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array.length == 0) return 0;
        int halfLen = array.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 0;
        for (int i = 0; i < array.length; i++) {
//            if (map.get(array[i]) == null) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > halfLen)
                r = key;
        }
        return r;
    }
}