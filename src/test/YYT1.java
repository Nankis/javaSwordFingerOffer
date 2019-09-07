package test;

import java.util.*;

public class YYT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //AAABBBAAABBBAAAABBBAABBBAAAABBBBA    B=16   16%3=1       A=17%3 = 2
        //AAA BBB BAAA BB BAAA BB BAAA BB BAAA BB BAAA AA BBB  ==>BAA     A -> 2  B -> 1
        //AAA BBB BAAA BB BAAA BB BAAA BB BAAA BB BAAA AA BBB  ==>BAA
        //BAABBAABBBABAC -->BC
        //每次维护答案字符串res, 使得res不存在三个以上相同的字符 (出现三次就删除，不是三次以上)
        while (sc.hasNext()) {
            String S = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (sb.length() >= 2 //不能>=3    i用来控制不会只有2个就删除
                        && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) //先比较已存在的末尾两个是否相同
                        && sb.charAt(sb.length() - 1) == S.charAt(i)) {//再比较res里最后一位与接下来要加入res的是否相同,如果相同则构成3连串
                    sb.delete(sb.length() - 2, sb.length());//删除区间[a,b)
                } else {
                    sb.append(S.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}

