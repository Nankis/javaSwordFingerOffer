package t20_29;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 * *
 * ps:
 * 单链表有环，是指单链表中某个节点的next指针域指向的是链表中在它之前的某一个节点，这样在链表的尾部形成一个环形结构。
 * <p>
 * 参考图解:https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2020~29.md
 * 务必想象一遍图流程
 */
public class t23S {
}

class Solution23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        ListNode slow, fast;
        slow = fast = pHead;

        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
