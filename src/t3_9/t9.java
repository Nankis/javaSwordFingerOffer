package t3_9;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class t9 { //复习1,2
    public static void main(String[] args) {
        Solution9_ solution9 = new Solution9_();
        for (int i = 1; i <= 5; i++) {
            solution9.push(i);
        }
        System.out.println(solution9.pop());
        System.out.println(solution9.pop());
        System.out.println(solution9.pop());
        System.out.println(solution9.pop());
        System.out.println(solution9.pop());
        System.out.println(solution9.pop());

    }
}

class Solution9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) //关键判断  重新push进stack2时,需要保证stack2是纯净的
            while (!stack1.empty())
                stack2.push(stack1.pop());

        if (stack2.empty()) return Integer.MIN_VALUE;

        return stack2.pop();
    }
}

class Solution9_ {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        if (stack2.isEmpty()) return Integer.MIN_VALUE;

        return stack2.pop();
    }
}