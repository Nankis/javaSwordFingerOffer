package t50_59;


/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class t58_2 {
    public static void main(String[] args) {
        Solution58_2 solution58_2 = new Solution58_2();
        System.out.println(solution58_2.LeftRotateString("abcXYZdef", 3));
    }
}

//不需要额外空间做法
//先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
class Solution58_2 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 1) return "";
        char[] ch = str.toCharArray();
        int len = ch.length - 1;
        reverse(ch, 0, n - 1);
        reverse(ch, n, len);
        reverse(ch, 0, len);
        return new String(ch);
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j)
            swap(ch, i++, j--);
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}

//额外空间做法
class Solution58_2_ {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 1) return "";
        StringBuilder sb = new StringBuilder();
        //n~length-1
        for (int i = n; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}


