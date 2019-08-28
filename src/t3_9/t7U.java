package t3_9;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 前得根    ----> 前序遍历得知根是哪个
 * 根入中    ----> 把得知的根带入中序遍历中(找到这个根在中序遍历的位置)
 * 中分左右  ----> 由刚才得的根的位置,其左右两边的就是左子树和右子树
 * 左右入前  ----> 再将左,右子树分别带入前序遍历中,重复上述,缩小范围
 * <p>
 * https://blog.csdn.net/u010189308/article/details/79807613  思路参考
 * 解析:
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%203~9.md#7-%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91
 * https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2004%20-%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91.md
 * <p>
 * 解题思路:
 * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
 * 左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
 */
public class t7U {
    public static void main(String[] args) {

    }
}

class Solution7 {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]); //根据前序值,确定根节点
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}