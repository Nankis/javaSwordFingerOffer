package t40_49;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class t40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        solution40.GetLeastNumbers_Solution(arr, 4);
    }
}

/**
 * 使用最大堆维护K个数(堆顶最大)，一直保持堆中有K个最小的数；
 * 堆顶元素就是K个数中的最大数，然后每次和外面的比较，如果有更小的，就替换堆顶即可；
 * 时间复杂度N*logK，也可以使用最小堆来做；
 * 代码参考:https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2040~49.md
 */
class Solution40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k <= 0) return new ArrayList<>();
        //本来的顺序就是参数的先后顺序o1、o2；
        //如果保持这个顺序就返回-1，交换顺序就返回1，什么都不做就返回0.
        //举个例子 传入2,3   3-2 = 1  交换顺序变为 3 2; 如果传入 3 2,   2-3 = -1  保持不变, 所以  该顺序还是3 2  即
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int v : input) {
            maxHeap.add(v);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
