package lcExtra;

public class t1004 {
    public static void main(String[] args) {
        // [1,1,1,0,0,0,1,1,1,1,0]
        // 2
        // [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
        // 3
//        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//        int k = 2;
        int k = 3;
        System.out.println(longestOnes(A, k));
    }

    //B站笔试题 // [1,1,1,0,0,0,1,1,1,1,0], K = 2  ==>6
    public static int longestOnes(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0;
        int window = 0;
        int res = 0;
        while (right < len) {
            if (A[right] == 0) {
                ++window;
            }
            while (window > K) {
                if (A[left++] == 0) {
                    --window;
                }
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }
}
