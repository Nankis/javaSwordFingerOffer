package t20_29;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class t29 {
}

class Solution29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
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
            if (top != bottom)
                for (int i = right - 1; i >= left; --i) list.add(matrix[bottom][i]);

            //bottom to top
            if (left != right)
                for (int i = bottom - 1; i > top; --i) list.add(matrix[i][left]);

            left++;
            top++;
            right--;
            bottom--;
        }
//
//        for (int n : list) {
//            System.out.println(n);
//        }
        return list;
    }
}

