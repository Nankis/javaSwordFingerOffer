package t3_9;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 * <p>
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 * <p>
 * 关键词:长度n,所有数字都在0~n-1范围内   数组下标不会越界
 * 核心思想: 将值为 i 的元素调整到第 i个位置上  //交换之前,先判断是否在i位置已经有i的值,有则重复
 */

public class t3 { //复习1,2
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 0, 2, 5};
        System.out.println(s3.duplicate(arr,6,new int[1]));
    }
}

class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length < 1) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            //用两层循环, 第一层相当于起固定作用..
            //2,3,1,0,2,5
            while (numbers[i] != i) {//2 !=0
                if (numbers[i] == numbers[numbers[i]]) { //相同的就会相等  比如num[0] == num[num[0]]  ===> mum[0] == mum[0]
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, numbers[i], i);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

class s3 {//{2, 3, 1, 0, 2, 5};

    public static boolean duplicate(int numbers[], int length, int[] duplication) {

        int len = 0;
        while (len < length) {
            for (int i = 0; i < length; i++) {
                if (numbers[i] != i) {
                    if (numbers[i] == numbers[numbers[i]])
                        duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, numbers[i], i);
            }
            len++;
        }

        return false;

    }

    private static void swap(int[] numbers, int j, int i) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

    }
}