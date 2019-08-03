package test;

import java.util.Scanner;

public class t_wy2019_2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//
//        }

        int res = 0;
        for (int i = 3; i <= 101; i = i + 2) {
            System.out.println(i + "x" + (i + 2));
            res = res + (i * i + 2);
        }
        System.out.println(res);
    }

}

