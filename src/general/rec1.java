package general;

import java.util.ArrayList;

/**
 * https://mp.weixin.qq.com/s/_8LFejdp9yUMeKqrx-q9YQ
 * 利用构造器--递归生成函数
 * 基本情况：规定 0 属于集合 S 。
 * 构造器：如果一个数 x 属于集合 S ，那么 x + 1 也属于集合 S 。
 * 解释:  0属于集合S, 那么 0+1 ,1+1,....也属于S
 * 总结：学习新东西后时时刻刻都要想着怎么用出来，数学、算法本身就是很多问题的抽象，学得好是一方面，怎么把抽象的东西实例化，应该时刻惦记着。
 * ---
 * 假设我知道了如何生成任意 x (x <= n - 1) 对括号的所有合法解的序列，如何生成 n 对括号的解？
 * 可以，generate(n) = "(" + generate(i) + ")" + generate(j) ，其中 i + j == n - 1 ，因为构造器里有一对括号(所以n-1)。
 * ---
 * 类比刚才的数学问题，我们模仿一下，生成求解的集合 S：
 * 基本情况：规定空串 "" 属于 S
 * 构造器：S 中的任意两个串 s 和 t 这样组合得到 v = (s)t，v 也属于 S
 */
public class rec1 {
    public static void main(String[] args) {
        rec rec = new rec();
        System.out.println(rec.generator(3));
    }
}

class rec {
    public ArrayList<String> generator(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            res.add(""); //基本情况
//            return res;
        }
        for (int i = 0; i < n; i++)
            for (String left : generator(i)) //挑选s
                for (String right : generator(n - i - 1)) //挑选t
                    res.add("(" + left + ")" + right);//构造

        return res;
    }
}
