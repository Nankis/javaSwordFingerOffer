package t20_29;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * *       	     8
 * *     	   /  \
 * *     	  6   10
 * *     	 / \  / \
 * *    	5  7 9 11
 * *     	镜像二叉树
 * *  	         8
 * *     	   /  \
 * *    	  10   6
 * *     	 / \  / \
 * *     	11 9 7  5
 * 思路: 通过多次左右子树交换,最终形成镜像树
 */
public class t27 {
    // 一 递归式
    public void Mirror(TreeNode root) {
        TreeNode temp = null;

        if (root != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;

            if (root.left != null) Mirror(root.left);
            if (root.right != null) Mirror(root.right);
        }
    }

}
