package test3;

import java.util.Scanner;

public class ddt2 {
    public static void main(String[] args) {
        //5 3
        //1 2 3 4 5   res = 6
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int p1 = 0, p2 = 0, min = 0, res = 0;
        for (; p2 < m; p2++) {
            min += nums[p2];
        }

        while (p2 < nums.length) {
            p2++;
            p1++;
            min = Math.min(min, getSum(nums, p1, p2));

            if (p2 == nums.length - 1) {//最后单独计算
                int temp = 0;
                for (int i = p2; i > p1; i--) {
                    temp += nums[i];
                }
//                System.out.println(temp+"temp");
                min = Math.min(min, temp);
            }
        }
        System.out.println(min);
    }

    //传入一个数组,计算该数组指定范围的和
    //1 2 3 4 5 6
    public static int getSum(int[] nums, int p1, int p2) {//p1=1, p2=3
        int res = 0;
        for (int i = p1; i < p2; i++) {
            res += nums[p1];
        }
        return res;
    }
}
