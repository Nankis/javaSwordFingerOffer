package lcExtra;

import java.util.Stack;

public class t1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(S.charAt(i))) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
