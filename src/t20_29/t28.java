package t20_29;


/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class t28 {
}

class Solution28 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}


class s28 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}