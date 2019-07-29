package t3_9;


import javafx.beans.value.ObservableNumberValue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */

public class t6 {  //不需要复习
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        ListNode listNode = new ListNode(-1);

        for (int i = 1; i <= 4; i++) {
            listNode.next = new ListNode(i); // -1 , 4
        }

        while (listNode.next.next != null) {
            System.out.println(listNode.val);
        }
//        System.out.println(solution6.printListFromTailToHead(listNode));
    }

}


class Solution6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}

