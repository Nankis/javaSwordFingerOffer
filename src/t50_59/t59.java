package t50_59;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class t59 {
}

class Solution59 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size > num.length || size < 1) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1)); //构造大顶堆,Java默认最小堆
        for (int i = 0; i < size; i++)
            maxHeap.offer(num[i]);
        res.add(maxHeap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) { /*维护一个size的大顶堆*/
            maxHeap.remove(num[i]);//先移除最左边的数
            maxHeap.offer(num[j]);//添加最右边的数
            res.add(maxHeap.peek());//取该区间最大的数
        }
        return res;
    }
}