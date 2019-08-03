package test;

import java.util.Scanner;

/**
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 */
public class wy2018t3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {

            String s = in.next();
            char[] ch = s.toCharArray();
            double type = 1;
            int len = ch.length;
            char cur = ch[0];
            for (int i = 1; i < ch.length; i++) {
                if (cur != ch[i]) { // a == a
                    cur = ch[i];
                    ++type;
                }
            }
            double result = len / type;
//            System.out.println("type:" + type);
//            System.out.println("len:" + len);
            System.out.println(String.format("%.2f",result));
        }
    }
}
