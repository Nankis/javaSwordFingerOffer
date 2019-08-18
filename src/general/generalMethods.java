package general;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class generalMethods {

}

/**
 * 前序遍历 leetcode 144
 * 中序遍历 leetcode 94
 * 后续遍历 leetcode 145
 */
class Solutiont144 {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            //递归模式只需要改变res.add的位置
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }
}

/**
 * 非递归方式的前中后序遍历
 * <p>
 * 有这么一棵树     假设现在在栈的指令是visit A
 * *                      1. visitA进栈
 * *        	 A           |        |   2.              | print A| 3.因此现在操作是先printA,再重复上述
 * *      	   /  \          |        |   在pop后===>>    | visit B|
 * *      	  B    C        | visitA |                   | visit C|
 * *      	 / \            ---------                    ---------
 * *     	D  E
 * *
 */


class generalPrintTree {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Guide> path = new Stack<>();

        path.push(new Guide(0, root));
        while (!path.isEmpty()) {
            Guide cur = path.pop();
            if (cur.node == null) continue;
            if (cur.ope == 1) { //当前指令是要输出,则输出(放到res里)
                res.add(cur.node.val);
            } else { //当前指令是要遍历这个node的子节点
                // 核心代码  ope = 1放在最后是前序, 1放在中间是中序, 1放在第一行是后序, 交换right和left位置可以是其他遍历方式
                path.push(new Guide(0, cur.node.right));
                path.push(new Guide(0, cur.node.left));
                path.push(new Guide(1, cur.node));
            }
        }
        return res;
    }

    class Guide {
        //Guide 可以认为是一个指令,这个指令里存有操作符ope 和node节点
        int ope = 0;  //0 ->visit, 1 ->print
        TreeNode node;

        public Guide(int ope, TreeNode node) {
            this.ope = ope;
            this.node = node;
        }
    }

}
