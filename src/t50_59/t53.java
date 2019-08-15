package t50_59;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 思路:
 * 找到key的下一个索引减去key第一次出现的索引 (二分法)
 * 1, 2, 3, 3, 3, 3, 4, 6    key=3  索引2   最后一个key的下一个索引6   6-2 =4
 * 所以有4个key
 */
public class t53 {
}

class Solution53 {
    public int GetNumberOfK(int[] array, int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int[] array, int k) {
        int l = 0, h = array.length; //h需要求出mid 所以不需要-1
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (array[mid] >= k)
                h = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}


