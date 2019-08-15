package t50_59;


/**
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 * <p>
 * Output:
 * "student. a am I"
 */
public class t58_1 {
    public static void main(String[] args) {
        Solution58_1_ solution58_1_ = new Solution58_1_();

        System.out.println(solution58_1_.ReverseSentence("I am a student."));

    }
}


//class Solution58_1 {
//    public String ReverseSentence(String str) {
//        if (str == null || str.trim().equals("")) return str;
//        String[] s = str.split(" ");
//        //先整体反转
//        reverseWord(s, 0, s.length - 1);
//
//
//    }
//
//    private void reverseWord(String[] str, int s, int e) {
//        while (s < e)
//            swap(str[s++], str[e++]);
//    }
//
//    private void swap(String s1, String s2) {
//        String temp = s1;
//        s1 = s2;
//        s2 = temp;
//    }
//}


//传统解法  ---不理想
//题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，
// 但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
class Solution58_1_ {
    public String ReverseSentence(String str) {
        //trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾的空格都被删除了
        // 例子如下：String s=" Hello World ".trim();就是把"Hello World"放入s中。
        // 注意:中间的空格不会被删除
        if (str == null || str.trim().equals("")) return str;

//        String s[] = str.split("\\s+");
        String s[] = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = s.length - 1; i >= 0; i--) {
//            System.out.print(s[i] + " ");
            sb.append(s[i]);

            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}