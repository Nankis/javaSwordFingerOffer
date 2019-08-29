package t20_29;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class t29 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4,}, {5, 6, 7, 8,}, {9, 10, 11, 12,}, {13, 14, 15, 16}};
        ArrayList<Integer> list = Solution29.printMatrix(arr);

    }
}

/**
 * 1.所有的循环都有i, int i是从left,top+1,right-1,bottom-1开始赋值
 * 2.res.add-->  matrix[left][i], [i][right],[bottom][i], [i]left]  i和left 两两对称
 * 3.末尾两个if判断不等再循环,最后一个for循环没有=
 */
class Solution29 { //复习1
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length; //行
        int col = matrix[0].length; //列
        if (row == 0 || col == 0) return list;
        //定义4个关键变量,表示左,上,右,下的打印范围
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; ++i) list.add(matrix[left][i]);

            // top to bottom  注意此处是top + 1   打印的是[i][right]
            for (int i = top + 1; i <= bottom; ++i) list.add(matrix[i][right]);

            //right to left
            if (top != bottom)  //注意 此处要right-1
                for (int i = right - 1; i >= left; --i) list.add(matrix[bottom][i]);

            //bottom to top
            if (left != right)
                for (int i = bottom - 1; i > top; --i) list.add(matrix[i][left]);

            left++;
            top++;
            right--;
            bottom--;
        }
//        for (int n : list) {
//            System.out.println(n);
//        }
        return list;
    }
}


class s29 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, top = 0, right = cols, bottom = rows;
        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) res.add(matrix[left][i]);
            //top to bottom
            for (int i = top + 1; i <= bottom; i++) res.add(matrix[top][right]);
            //right to left
            if (top != bottom)
                for (int i = right - 1; i >= left; i--) res.add(matrix[bottom][i]);
            //bottom to top
            if (left != right)
                for (int i = bottom - 1; i > top; i--) res.add(matrix[i][left]);

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}

