package t3_9;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Test {
    public static void main(String[] args) {
        //从后面开始构造
        // head -> 1
        // head -> 2 -> 1
        ListNode head = null;
        for (int i = 1; i <= 5; i++) {
            ListNode t = new ListNode(i);
            t.next = head;  //执行这条之前 t.next == null
            head = t;
        }

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

//    public ListNode getNode(ListNode listNode) {
//        if (listNode != null) {
//            getNode(listNode.next);
//        } else {
//            listNode.val = 1;
//        }
//        return listNode;
//    }
}