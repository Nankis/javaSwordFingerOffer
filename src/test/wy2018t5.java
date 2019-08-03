package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * <p>
 * 2
 * 3
 * 1 10 100
 * <p>
 * 4
 * 1 2 3 4
 */
public class wy2018t5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();

            for (int i = 0; i < count; i++) {
                int length = in.nextInt();
                int flag2 = 0;
                int flag4 = 0;

                for (int j = 0; j < length; j++) {
                    int num = in.nextInt();
                    if (num % 4 == 0) {
                        flag4++;
                    } else if (num % 2 == 0) {
                        flag2++;
                    }
                }

                if ((flag4 * 2 + flag2 + 1) > length) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        in.close();
    }

}
