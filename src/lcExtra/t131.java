package lcExtra;

import java.util.ArrayList;
import java.util.List;

public class t131 {
    static List<List<String>> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(partition("aab"));

    }

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() < 1) return res;
        backtrack(s, path);
        return res;
    }

    private static void backtrack(String s, List<String> path) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String ts = s.substring(0, i);
            if (isNotP(ts))
                continue;
            path.add(ts);
            backtrack(s.substring(i), path);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isNotP(String s) {
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return true;
        }
        return false;
    }
}
