package t10_19;

/**
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class t15 {
    public static void main(String[] args) {
        for (int i = 2; i <= 5; i++) {
            System.out.print(i + " ");
            System.out.println(i & (i - 1));
        }
    }
}


class Solution15 { //复习1,
    public int NumberOf1(int n) {
        //方法1  比较普通
        int count = 0;
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * n&(n-1)  //把n二进制最末尾的1变成0
     * 该位运算去除 n 的位级表示中最低的那一位。
     * -->也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
     * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     * 时间复杂度：O(M)，其中 M 表示 1 的个数。
     *
     * @param n
     * @return
     */
    public int NumberOf1s(int n) {
        //方法2  比方法1效率高
        int count = 0;
        while (n != 0) { //n不能是0  如果一个整数不为0，那么这个整数至少有一位是1。
            ++count;
            n &= (n - 1);
        }
        return count;
    }
}


class S15 {
    public int NumberOf(int n) {
        char[] ch = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                ++count;
            }
        }
        return count;
    }

    public int NumberOf2(int n) {

        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            ++count;
        }
        return count;
    }

}