package t40_49;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 */
public class t43 {
}

//O(n^2) //该算法不能去大厂  更优算法:https://www.cnblogs.com/xuanxufeng/p/6854105.html
class Solution43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '1')
                    ++count;
            }
            n--;
        }
        return count;
    }

}

//lgN 解法: https://blog.csdn.net/yi_afly/article/details/52012593
//https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2031%20-%20%E6%95%B4%E6%95%B0%E4%B8%AD1%E5%87%BA%E7%8E%B0%E7%9A%84%E6%AC%A1%E6%95%B0%EF%BC%88%E4%BB%8E1%E5%88%B0n%E6%95%B4%E6%95%B0%E4%B8%AD1%E5%87%BA%E7%8E%B0%E7%9A%84%E6%AC%A1%E6%95%B0%EF%BC%89.md

class Solution43_ {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        int res = 0;
        // base表示当前判断的位数、cur表示当前位、height表示高位
        int base = 1, cur, height = n;
        while (height > 0) {
            cur = height % 10;
            height /= 10;
            res += height * base; //先加上一开始的
            if (cur == 1)
                res += (n % base) + 1; //==1 就要看前面的了
            else if (cur > 1)
                res += base; //后面剩的，>1 还要+base
            base *= 10;
        }
        return res;
    }
}