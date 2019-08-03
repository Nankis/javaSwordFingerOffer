package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t_wy2019_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("班级人数:");
        while (in.hasNext()) {

            int n = in.nextInt();
            int arr[] = new int[n + 1];

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                System.out.println("输入学生" + i + "成绩:");
                arr[i] = in.nextInt();
                map.put(i, 0);
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (arr[i] >= arr[j]) {
                        map.put(i, map.get(i) + 1);
                    }
                }
            }

            System.out.println("输入需要查询的次数:");
            int q = in.nextInt();
            int c = q;
            double[] res = new double[q + 1];

            while (q > 0) {
                System.out.println("输入需要查询的学生编号:");
                int stu_i = in.nextInt();
                System.out.println("学生" + stu_i + "超过分数人数" + map.get(stu_i) + " " + "班级总人数" + n);
//                System.out.println((map.get(stu_i) - 1) / n + " " + q);
                if (map.get(stu_i) > 0) {
                    res[stu_i] = ((double)(map.get(stu_i)) / n) * 100;
                }
                --q;
            }

            for (int i = 1; i <= c; ++i) {
//                System.out.printf("%.6f", res[i]);
                System.out.println(String.format("%.6f", res[i]));
            }

            System.out.println("班级人数:");
        }
    }
}
