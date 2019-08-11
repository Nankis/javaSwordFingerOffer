package t50_59;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 参考:
 * https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2035%20-%20%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E9%80%86%E5%BA%8F%E5%AF%B9.md
 */
public class t51UI {
    public static void main(String[] args) {
        int i = 4;
        System.out.println(4 >> 1);
    }
}

class Solution51 {
    private final int mod = 1000000007;

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) return 0;
        return mergeRec(array, 0, array.length - 1);
    }

    private int mergeRec(int[] array, int L, int R) {
        if (L == R) return 0;
        int mid = L + ((R - L) >> 1);   //  (R+L)/2
        //先拆分左边和右边,  然后再归并两边    //左边不用%mod
        return ((mergeRec(array, L, mid) + mergeRec(array, mid + 1, R)) % mod + merge(array, L, mid, R)) % mod;
    }

    //[L,mid] 有序,  [mid+1,R] 有序
    private int merge(int[] array, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0, sum = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if (array[p1] <= array[p2]) {
                help[k++] = array[p1++];
            } else { //arr[p1] > arr[p2], 此时p2~R都小于arr[p1, mid]之间的元素，从这里求得逆序数
                sum += (mid - p1 + 1);
                sum %= mod; //?每次求sum都要mod?
                help[k++] = array[p2++];
            }
        }
        while (p1 <= mid) help[k++] = array[p1++];  //想象下---左边剩余部分
        while (p2 <= R) help[k++] = array[p2++]; //右边剩余部分
        for (int i = 0; i < k; i++)  // i < array.length 不对
            array[L + i] = help[i];  //  array[i] = help[i];  -->不对

        return sum;
    }
}
