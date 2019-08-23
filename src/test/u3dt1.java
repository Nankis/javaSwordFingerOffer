package test;

import java.util.HashMap;
import java.util.Scanner;

public class u3dt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //A 能不能有B 组成  ba ccccbbbbaaaa
        while (sc.hasNext()) {  //统计A字符次数
            String A = sc.next();
            String B = sc.next();
            String res = "";
            HashMap<Character, Integer> mapA = new HashMap<>();
            HashMap<Character, Integer> mapB = new HashMap<>();
            int p = 0;
            while (p < A.length()) {
                char c1 = A.charAt(p);
                mapA.put(c1, mapA.getOrDefault(c1, 0) + 1);
                p++;
            }
            p = 0;
            while (p < B.length()) {
                char c1 = B.charAt(p);
                mapB.put(c1, mapB.getOrDefault(c1, 0) + 1);
                p++;
            }

            for (char key : mapA.keySet()) {
                if (mapB.get(key) != null && mapB.get(key) >= mapA.get(key)) {
                    res = "YES";
                } else {
                    res = "NO";
                }
            }
            System.out.println(res);
        }

    }

}
