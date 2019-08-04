package t20_29;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class t26 {
}

class Solution26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当root1和root2均不为空的时候才进行比较,不然就直接返回false
        if (root1 != null && root2 != null) {
            //如果根节点相同,则直接开始匹配右子树是否还继续相同
            if (root1.val == root2.val) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            //如果找不到就让root1的左子树去当起点,再判断是否含有root2
            if (!result) result = HasSubtree(root1.left, root2);

            //   //如果找不到就让root1的右子树去当起点,再判断是否含有root2
            if (!result) result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        //如果root2遍历完了都还能对应上,则true
        if (root2 == null) return true;
        //如果root1遍历完了,root2还没遍历完,则返回false
        if (root1 == null) return false;

        //如果只要其中有一个节点没对应上,则直接返回false
        if (root1.val != root2.val) return false;

        //如果根节点对应上了,那么就分别去子节点匹配(子节点的左和右都要匹配)
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
}