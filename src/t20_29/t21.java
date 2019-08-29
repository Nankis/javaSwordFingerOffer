package t20_29;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class t21 {
    //1 5 8 2 3 4 6
}

class Solution21 {
    //空间换时间  ---> 两个队列实现
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 1) return;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) { //奇数
                queue.offer(array[i]);
            } else
                queue2.offer(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (!queue.isEmpty()) {
                array[i] = queue.poll();
            } else
                array[i] = queue2.poll();
        }
    }


    //方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
    public void reOrderArray2(int[] array) {
        if (array == null || array.length < 1) return;

        int N = array.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}