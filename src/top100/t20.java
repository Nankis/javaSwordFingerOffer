package top100;

import java.util.Stack;

public class t20 {
    public static void main(String[] args) {
        System.out.println(isValid2("()"));
    }

    public static boolean isValid2(String s) {
        if (s == null || s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
                //1.只输入左类型括号 或 2.左右括号不匹配
            else if (stack.isEmpty() || ch != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    //    s 仅由括号 '()[]{}' 组成
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> s1 = new Stack<>();
        for (char c : chars) {
            s1.push(c);
        }
        Stack<Character> s2 = new Stack<>();
        while (!s1.empty()) {
            char ch = s1.pop();
            if (ch == ')' || ch == ']' || ch == '}') {
                s2.push(ch);
            } else {
                if (s2.isEmpty()) return false;
                char ch2 = s2.pop();
                if (ch == '(' && ch2 != ')') return false;
                if (ch == '[' && ch2 != ']') return false;
                if (ch == '{' && ch2 != '}') return false;
            }
        }
        return s2.isEmpty();
    }
}
