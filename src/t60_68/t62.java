package t60_68;


/**
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，
 * 并且不再回到圈中，从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
 * 求出最后一个小朋友编号(小朋友的编号是从0到n-1)
 */
public class t62 {
}

class Solution62 {
    /*
     *这道题我用数组来模拟环，思路还是比较简单，但是各种下标要理清
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if (i >= n) i = 0;  //模拟环。
            if (array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if (step == m) {               //找到待删除的对象。
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }
}