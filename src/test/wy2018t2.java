package test;

import java.util.Scanner;

/**
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
 * 例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,
 * 之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。
 * 例如n = 100, 颠倒之后是1.
 * 5231
 * 1325
 * 6556
 */
public class wy2018t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int num = in.nextInt();
            StringBuilder sb = new StringBuilder();
            String temp = num + "";
            char[] ch = temp.toCharArray();

            for (int i = 0; i < ch.length; i++) {
                if (ch[0] != '0' || ch[ch.length - 1] != '0') {
                    sb.append(ch[i]);
                }
            }
            String rnum = sb.reverse().toString();
            int rn = Integer.parseInt(rnum);
            int result = 0;
            result = num + rn;
            System.out.println(result);
        }

    }

}
