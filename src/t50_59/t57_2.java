package t50_59;


import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 例如和为 100 的连续序列有：
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 */
public class t57_2 {
}

class Solution57_2 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int small = 1;
        int big = 2;
        int curSum = small + big;
        //因为这个序列至少要有两个数字，我们一直增加 small 到 (1+s)/2 为止
        int mid = (sum + 1) / 2;
        while (small < mid) {
            if (curSum == sum)
                packing(small, big);
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) packing(small, big);
            }
            //curSum<sum
            big++;
            curSum += big;
        }
        return res;
    }

    private void packing(int small, int big) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = small; i <= big; i++)
            temp.add(i);
        res.add(temp);
    }
}

//数学公式法
class Solution57_2s {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 1  2 3  = 6 ,  2 3 =5
        int plow = 1;
        int phight = 2;
        while (plow < phight) {
            int cursum = (plow + phight) * (phight - plow + 1) / 2;  // 等差数列求和公式
            if (cursum == sum) {
                packing(plow, phight);
                plow++;
                phight++;
            } else if (cursum < sum) {
                phight++;
            } else
                plow++;
        }
        return res;
    }

    private void packing(int small, int big) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = small; i <= big; i++)
            temp.add(i);
        res.add(temp);
    }
}