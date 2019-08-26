package t60_68;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class t66 {
}


class Solution66 {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for (int i = 0, mul = 1; i < len; mul *= A[i], i++) //从左往右累乘
            B[i] = mul;
        for (int i = len - 1, mul = 1; i >= 0; mul *= A[i], i--) //从右往左累乘
            B[i] *= mul;
        return B;
    }
}