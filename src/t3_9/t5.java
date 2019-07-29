package t3_9;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路: 遍历字符串长度,遇到空格,在末尾加两个任意字符.最后通过双指针替换掉空格.注意顺序相反
 * A B   -->  A B**  --> A%20B
 */
public class t5 { //复习1,
    public static void main(String[] args) {
        Solution5_ s5 = new Solution5_();
        StringBuffer sb = new StringBuffer("We Are Happy.");
        System.out.println(s5.replaceSpace(sb));
    }
}

class Solution5 {
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') { //在字符串末尾添加三个字符用于替代20% A B**  只需要填充两个就行
                str.append("**");
            }
        }
        int p2 = str.length() - 1; //str在填充字符串后,长度变大

        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}


class Solution5_ {
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.append("**");
            }
        }

        int p2 = str.length() - 1;
        while (p1 < p2 && p1 >= 0) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
