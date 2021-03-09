package top100;

public class t19 {
    public static void main(String[] args) {

    }

    //遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p1 = dummyHead, p2 = dummyHead;
        int step = 0;
        while (p1 != null) {
            //注意step不是>=n
            if (step > n) {
                p2 = p2.next;
            }
            p1 = p1.next;
            ++step;

            //此时p2已经指向倒数第n个节点,直接删除满足条件节点即可
            if (p1 == null) {
                p2.next = p2.next.next;
            }
        }
        return dummyHead.next;
    }

    //递归
    int cur = 0;

    //大概意思就是，不管从正着数第一个(head)，还是第二个(head->next)，还是第三个(head->next->next)开始算起，
    // 都不会影响从尾巴开始倒着数第n个节点的结果，除非正着数的第x个(head->next->next->......(x-1级next)->next)，
    // 正好和倒着数的第n个撞上了(楼主用cur变量标记x)，此时循环嵌套函数就运行到底，可以逐级返回了。
    // 不过，这样的话，那个要删除的节点，只是从list里面排除掉了，并没有被free，隐患可能是有个野指针。
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd2(head.next, n);
        cur++;
        if (n == cur) return head.next;
        return head;
    }
}
