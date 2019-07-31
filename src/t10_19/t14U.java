package t10_19;


/**
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 */
public class t14U {
    public static void main(String[] args) {
        Solutiont14 solutiont14 = new Solutiont14();
        System.out.println(solutiont14.integerBreak(7));
//        System.out.println(Math.pow(2, 3));
    }

}

class Solutiont14 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];

    }
}