package t10_19;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * *
 * *    a b c e
 * *    s f c s
 * *    a d e e
 * *
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class t12U {
    public static void main(String[] args) {
        int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};//分别对应上移,下移  左移 右移
        char[] array = {'B', 'C', 'E', 'S', 'F', 'C', 'A', 'D', 'E', 'E'};
        char[] str = {'A', 'B', 'C', 'C', 'E', 'D'};

        Solution12 solution12 = new Solution12();
        System.out.println(solution12.hasPath(array, 3, 4, str));
    }

}


class Solution12 {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};//分别对应上移,下移  左移 右移
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, str, marked, 0, i, j))
                    return true;

        return false;
    }

    //从matrix[r][c]开始,寻找Word[pathLen...matrix.size()]
    private boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == str.length) return true;

        //判断是否越界或者当前位置的字母不匹配,或者当前位置已经走过了
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }

        //以上条件都没有满足,那么就可以走,先标记当前位置走过
        marked[r][c] = true;

        //依次取出一对数组,按照步数数组上下左右走,pathLen要+1  从新的一步走
        for (int[] n : next)
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;

        // 回退,重置标记位
        marked[r][c] = false;

        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[c][r] = array[idx++];
            }
        }
        return matrix;
    }
}


//class Solution12_ {
//    static int row, col;
//
//    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
//        if (rows == 0 || cols == 0) return false;
//
//        buildMatrix()
//
//    }
//}