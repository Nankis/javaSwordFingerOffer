package t30_39;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 参考:
 * https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2023%20-%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97.md
 */
public class t33 {
}

// 1 2 3 6 8 7 5
class Solution33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;

        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int L, int R) {
        if (L >= R) return true; //前面的已经满足条件

        int root = sequence[R];
        int i = L;
        //找到左右子树的分界,注意:之所以是<=R-1是因为最后一个是root
        while (i < R && sequence[i] < root)
            i++;
        int mid = i; // seq[mid] > root, 从mid开始是右子树，必须都>root
        while (i < R) {
            if (sequence[i] < root) //如果右子树的值比root还小,那么就不是
                return false;
            i++;
        }
        return verify(sequence, L, mid - 1) && verify(sequence, mid, R - 1); //左右两边都是满足条件的
    }


}