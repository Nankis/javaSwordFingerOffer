package t50_59;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * <p>
 * 思路:
 * 利用二叉查找树中序遍历有序的特点。
 */
public class t54 {
}

class Solution54 {
    TreeNode ret = null;
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;

    }

    private void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null || count >= k) return;
        inOrder(pRoot.left, k);
        count++;
        if (count == k)
            ret = pRoot;
        inOrder(pRoot.right, k);
    }
}