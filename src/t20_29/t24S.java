package t20_29;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 参考:https://www.javazhiyin.com/32787.html
 */
public class t24S {
}

/**
 * 反序的过程整个链表分成两个部分，前面的代表已反序，后面的代表待反序，
 * 反序和待反序是断开的，所以要注意保存这两条链表的头节点
 * ListNode next = null;//用来保存待反序的第一个节点（cur 和 next节点）
 * ListNode pre = null;//用来保存已经反序的第一个结点
 * <p>
 * ---
 * next = cur.next;//首先记录当前节点的下一个节点，（保存起来）
 * head.next = pre;//让当前节点指向前一个节点，因为要反序嘛
 * pre = cur;//让前一个节点值，取代当前的节点值。因为要继续向下走
 * head = next;//让下一个节点，取代当前节点。同样是向下走，为下一次循环做准备
 * *
 * *
 * *
 * 想象三个指针   pre  cur==head  next
 * next = cur.next;   xxx.next  是xxx的指向改变,  而  xxx = cur 是xxx的本体指针移动
 * cur.next = pre;
 * pre = cur;
 * cur = next;
 */
class Solution24 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, next = null, cur = head;
        while (cur != null) {
            /*记忆: 赋值给别人后,下一次就自己就是被赋值的对象*/
            next = cur.next;
            cur.next = pre;    //反序操作
            pre = cur;     //在当前节点切换到下一个节点之前先让前驱指针指向当前节点
            cur = next;  //重置cur新的一轮循环开始
        }
        return pre;
    }


    //递归实现
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;   //先把当前节点之后的节点交给next节点,保证链表不断开
        head.next = null;            //再把当前节点断开
        ListNode newHead = ReverseList(next);  //反转next剩下的部分
        next.next = head;            //反向连接已被断开的链表
        return newHead;
    }

}
