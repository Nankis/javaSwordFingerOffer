package t30_39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class t32_2 {
}

class Solution32_2 {
    /**
     * 非递归方法
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) return res;
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            //按层处理
            int len = queue.size(); //区分每层的长度
            ArrayList<Integer> tempL = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                tempL.add(cur.val);
                //下面两步的操作会导致queue的size改变所以i<queue.size()这个条件不能用,需要额外的len来控制层数
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(tempL);

        }
        return res;

    }

}

class Solution32_2d {
    /**
     * 递归写法，可以前序，中序和后序（中序和后序要先建出所有中间的ArrayList）。
     * 参考:
     *https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/LeetCode/Tree/LeetCode%20-%20102.%20Binary%20Tree%20Level%20Order%20Traversal(%E5%B1%82%E6%AC%A1%E9%81%8D%E5%8E%86%E4%BF%9D%E5%AD%98).md
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> res= new ArrayList<>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        printTree(pRoot, 0);
        return res;
    }

    private void printTree(TreeNode node, int level) {
        if (node == null) return;
        if (res.size() <= level) {  //当前层还没有建
            ArrayList<Integer> tempL = new ArrayList<>();
            tempL.add(node.val);
            //把当前层加入res中
            res.add(tempL);
        } else { //该层已经建过了
            res.get(level).add(node.val);
        }
        printTree(node.left, level + 1);
        printTree(node.right, level + 1);
    }

}