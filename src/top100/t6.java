package top100;

import java.util.ArrayList;
import java.util.List;

public class t6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));

    }

    public static String convert(String s, int numRows) {
        if (s == null || numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
