package t10_19;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * 递归:   当核心逻辑完成后, 下一步就是从1开始!   即---只看函数名便知道可以做什么.  (不能一直跟踪函数,否则容易被绕晕,只要直到这个函数是干什么的,然后调用就行)
 */
public class t18_2S {//不懂??
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(3);
        pHead.next.next.next.next = new ListNode(5);

        Solution18.deleteDuplication(pHead);
    }
}

class Solution18 {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;  //只有0或则1个节点则不用删除
        }

        if (pHead.val == pHead.next.val) { //当前节点是重复节点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                //跳过与当前pHead重复的节点,直到遇到第一个不重复的节点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        } else {
            //pHead的下一个节点不是重复的,那么保留第一个,从下一个开始递归
            //值得注意的是pHead.next = deleteDuplication(pHead.next); 这句,这句保证了,pHead连接剩下的不重复节点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }

    /**
     * 递归  1->2->3->3->4->4->5
     */
    public static ListNode deleteDuplication3(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode cur = pHead, next = pHead.next;
        if (cur.val != next.val) {
            cur.next = deleteDuplication(next);
            return cur;
        } else {
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        }
    }


    /**
     * 非递归实现
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        ListNode newHead = new ListNode(-1); //设置一个头指针
        newHead.next = pHead;
        ListNode cur = pHead;
        ListNode last = newHead; //最后返回的是头指针

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) //如果后面还有重复的值则继续查找 该条件不能对换
                    cur = cur.next;

                last.next = cur;
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}


//class Solutions {
//    public ListNode deleteDuplication(ListNode pHead) {
//        if (pHead == null) return pHead;
//
//        while (pHead != null) {
//            int val = pHead.next.val;
//
//            while (pHead.val==val) {
//                pHead = pHead.next;
//            }
//            pHead
//
//        }
//
//
//    }
//}