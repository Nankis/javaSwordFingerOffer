package t50_59;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
 */
public class t57_1 {
}


//题目说要找到乘积最小的，可以发现，L、R隔的越远，arr[L] * arr[R]乘积越小，所以我们的做法没问题。
class Solution57_1 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int L = 0, R = array.length - 1;
        while (L < R) {
            int cur = array[L] + array[R];
            if (cur == sum) {
                res.add(array[L]);
                res.add(array[R]);
                return res;
            } else if (cur < sum)
                L++;
            else
                R--;
        }
        return res;
    }
}