package t60_68;

/**
 * 求 1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C。
 */
public class t64 {

}


class Solution64 {
    public int Sum_Solution(int n) {
        int sum = 0;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}