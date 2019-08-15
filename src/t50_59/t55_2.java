package t50_59;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 首先我们知道平衡二叉树是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树；
 * 我们可以使用一个获取树的高度的函数depth()。然后递归比较左右子树是不是平衡二叉树且左右子树的高度不超过1即可。
 * 这里获取高度需要logN复杂度，主函数isBalance需要O(N)，所以总的时间复杂度为N*logN；
 */
public class t55_2 {
}

class Solution55_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;

        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        //递归要理解成子问题:左子树的高度，右子树的高度，他们的最大高度就是子树的高度，再加1就是这一层的高度
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}