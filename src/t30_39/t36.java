package t30_39;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class t36 {
}

class Solution36 {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOder(pRootOfTree);
        return head;
    }

    /**
     * *         2 (node/cur)
     * *       /  \
     * *     1     3
     * *   (pre)
     * 中序遍历(保证二叉搜索树有序)
     * 每次记录上一个访问的结点pre，然后每次当前结点为空(访问到了最左边)的时候，就设置pre和cur的关系即可；
     */
    private void inOder(TreeNode node) {
        if (node == null) return;
        inOder(node.left);  //左子树剩下的树转换好
        node.left = pre;   //2-->1
        if (pre != null)
            pre.right = node; //双向链表 1-->2
        pre = node; // pre = cur
        if (head == null)
            head = node; //head == cur
        inOder(node.right); //右子树剩下的树转换好
    }
}