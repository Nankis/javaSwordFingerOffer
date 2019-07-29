package t3_9;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 思路:
 * https://www.jianshu.com/p/d77f7c67079c
 */
public class t8 {
}

class Solution8 { //复习1,
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //当前节点的右孩子不为空,它后代的最左节点就是下一个节点
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;  //以该节点的右孩子为入口
            while (pNode.left != null) pNode = pNode.left; //如果有右孩子,其后代最左孩子就是下一个中序遍历结果
            return pNode;
        }

        //要查找的当前节点没有右孩子,返回查询它作为父亲节点左孩子的父亲节点
        //先判断其有没有父亲节点
        while (pNode.next != null) {
            if (pNode == pNode.next.left) return pNode.next;  //当前节点是它父亲节点的左孩子,则返回父亲节点
            pNode = pNode.next;  //否则继续往上找
        }

        //如果两者都没有就不存在下一个节点
        return null;
    }
}


class Solution8_ {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            pNode = pNode.right; //以其右孩子为入口
            while (pNode.left != null) pNode = pNode.left; //如果有右孩子,其后代最左孩子就是下一个中序遍历结果
            return pNode;
        }

        //要查找的当前节点没有右孩子
        //先判断其有没有父亲节点
        while (pNode.next != null) {
            if (pNode == pNode.next.left) { //当前节点的父亲节点是当前节点爷爷节点的左孩子则,返回爷爷节点
                return pNode.next;
            } else pNode = pNode.next;
        }
        return null;
    }
}