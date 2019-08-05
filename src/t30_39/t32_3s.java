package t30_39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 参考: https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/LeetCode/Tree/LeetCode%20-%20103.%20Binary%20Tree%20Zigzag%20Level%20Order%20Traversal.md
 */
public class t32_3s {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 5; ++i) {
            list.add(i);
        }

        for (Object v : list)
            System.out.print(v + " ");

        System.out.println();

        ArrayList list2 = new ArrayList();
        for (int i = 1; i <= 5; ++i) {
            list2.add(0, i);
        }

        for (Object v : list2)
            System.out.print(v + " ");
        ///////// add(e)  ---> 相当于append   add(0,e) 相当于要插入list的0号索引,即第一个位置,所以所有元素往后移
    }
}

/**
 * 非递归模式
 */
class Solution32_3s {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) return res;
        queue.offer(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempL = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                tempL.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            if (reverse) Collections.reverse(tempL);
            reverse = !reverse;
            res.add(tempL);
        }
        return res;
    }

}

/**
 * 递归模式
 */
class Solution32_3ss {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        printTree(pRoot, 0);
        return res;
    }

    private void printTree(TreeNode node, int level) {
        if (node == null) return;
        if (res.size() <= level) res.add(new ArrayList<>());//不用再额外创建tempL数组,因为通过level下标就可以获取对应层数的list
        if (level % 2 == 0)
            res.get(level).add(node.val);
        else
            res.get(level).add(0, node.val);

        printTree(node.left, level + 1);
        printTree(node.right, level + 1);

    }

}