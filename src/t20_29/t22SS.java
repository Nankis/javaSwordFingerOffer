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
public class t22SS {
}

/**
 * 指针p和q都先指向开始的节点，p一直向后走，而q等到p走了k步再开始向后走，
 * 从这个时刻起p总是领先q k个位置，当p走到终点时，q走到了倒数第k个节点。
 */
class Solution22 { //S   不理解就画图   //5,{1,2,3,4,5}
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int step = 0;
        for (; p != null; step++) {
            if (step >= k)
                q = q.next;
            p = p.next;
        }
        return step < k ? null : q;
    }
}

class Solution22_ { //S   不理解就画图   //5,{1,2,3,4,5}
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = head;
        q = head;
        int step = 0;
        while (p != null) {
            if (step >= k)
                q = q.next;
            p = p.next;
            step++;
        }
        return step < k ? null : q;
    }
}