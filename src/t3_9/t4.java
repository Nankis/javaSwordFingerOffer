package t3_9;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * <p>
 * 思路: 横向最大, 纵向最小
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 */
public class t4 { //复习1,2
    public static void main(String[] args) {
        int arr[][] = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Solution4_ s = new Solution4_();
        System.out.println(s.Find(33, arr));
    }
}

class Solution4 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length < 1 || array[0].length < 1) return false;
        int rows = array.length - 1;
        int c = array[0].length - 1;
        int r = 0;

        while (r <= rows && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target < array[r][c]) {
                c--;
            } else
                r++;
        }
        return false;
    }
}


class Solution4_ {
    public boolean Find(int target, int[][] array) {
        if (array == null || array[0].length < 1) return false;

        int rows = array.length;
        int cols = array[0].length;

        int r = 0, c = cols - 1;
        while (r < rows) {
            if (target > array[r][c]) {
                r++;
            } else if (target < array[r][c]) {
                c--;
            } else
                return true;
        }

        return false;
    }
}


