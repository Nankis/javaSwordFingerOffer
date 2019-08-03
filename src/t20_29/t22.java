package t20_29;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class t22 {
}

class Solution22 { //S   不理解就画图
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}