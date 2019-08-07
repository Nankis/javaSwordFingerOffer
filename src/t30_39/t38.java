package t30_39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 参考:
 * https://www.nowcoder.com/profile/4671267/codeBookDetail?submissionId=18873698
 * https://blog.csdn.net/summerxiachen/article/details/60579623
 */
public class t38 {
}

class Solution38 {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null || str.length() > 0) {
            permutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    private void permutationHelper(char[] ch, int i, List<String> list) {
        if (i == ch.length - 1) {
            String val = String.valueOf(ch);
            if (!list.contains(val))
                list.add(val);
        } else for (int j = i; j < ch.length; j++) {
            swap(ch, i, j);
            permutationHelper(ch, i + 1, list);
            swap(ch, i, j);  //回溯, 交换回来
        }

    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}